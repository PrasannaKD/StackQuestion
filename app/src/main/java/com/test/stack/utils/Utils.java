package com.test.stack.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.github.marlonlom.utilities.timeago.TimeAgo;
import com.test.stack.GlideApp;
import com.test.stack.R;

import timber.log.Timber;
/**
 * a common utils class for the app.
 */
public class Utils {

    private static final String NEW_API = "NewApi";

    /**
     * Load round image into imageview.
     *
     * @param context ui context.
     * @param url     image url.
     * @param iv      image view.
     */
    public static final void loadRoundImage(final Context context, String url, final ImageView iv) {
        GlideApp.with(context).asBitmap()
                .load(url)
                .placeholder(R.drawable.ic_profile_24dp)
                .error(R.drawable.ic_profile_24dp)
                .centerCrop()
                .into(new BitmapImageViewTarget(iv) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        iv.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    /**
     * Return time stamp for epoch time.
     *
     * @param epoch unix time stamp.
     * @return time stamp in string with particular format eg: Dec 29, 2107
     */
    public static String timeStampRelativeToCurrentTime(long epoch) {
        Timber.d("timeStampRelativeToCurrentTime %s", TimeAgo.using(epoch));
        return TimeAgo.using(epoch );
    }

    /**
     * @param context           UI context.
     * @param drawableVectorRes Drawable vector resource.
     * @param imageView         Image view.
     */
    public static void setTintedVectorAsset(Context context, @DrawableRes int drawableVectorRes,
                                            ImageView imageView) {
        imageView.setImageDrawable(getTintedVectorAsset(context, drawableVectorRes));
    }

    /**
     * @param context           UI context.
     * @param drawableVectorRes Drawable vector resource.
     * @param imageView         Image view.
     */
    public static void setTintedVectorAsset(Context context, @DrawableRes int drawableVectorRes,
                                            ImageView imageView, @ColorRes int colorRes) {
        imageView.setImageDrawable(getTintedVectorAsset(context, drawableVectorRes, colorRes));
    }

    /**
     * @param context           UI context.
     * @param drawableVectorRes Drawable vector resource.
     * @return get tintd vector drawable
     */
    public static Drawable getTintedVectorAsset(Context context,
                                                @DrawableRes int drawableVectorRes) {
        VectorDrawableCompat nonWhite = VectorDrawableCompat.create(context.getResources(),
                drawableVectorRes, context.getTheme());
        Drawable white = DrawableCompat.wrap(nonWhite);
        return white;
    }

    /**
     * @param context           UI context.
     * @param drawableVectorRes Drawable vector resource.
     * @param colorRes          Tint color resource.
     * @return get tinted vector drawable
     */
    public static Drawable getTintedVectorAsset(Context context, @DrawableRes int drawableVectorRes,
                                                @ColorRes int colorRes) {
        VectorDrawableCompat nonWhite = VectorDrawableCompat.create(context.getResources(),
                drawableVectorRes, context.getTheme());
        Drawable white = DrawableCompat.wrap(nonWhite);
        DrawableCompat.setTint(white, ContextCompat.getColor(context, colorRes));
        return white;
    }


    /**
     * Slide Transition
     *
     * @param rootView Scene root.
     */
    @SuppressLint(NEW_API)
    public static void captureTransitionSlide(ViewGroup rootView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            TransitionManager.beginDelayedTransition(rootView, new Slide());
        }
    }

    /**
     * Explode Transition
     *
     * @param rootView Scene root.
     */
    @SuppressLint(NEW_API)
    public static void captureTransitionExplode(ViewGroup rootView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            TransitionManager.beginDelayedTransition(rootView, new Explode());
        }
    }

    /**
     * Slide Transition
     *
     * @param rootView Scene root.
     */
    @SuppressLint(NEW_API)
    public static void captureTransitionSlideRightToLeft(ViewGroup rootView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            TransitionManager.beginDelayedTransition(rootView, new Slide(Gravity.END));
        }
    }

    /**
     * Fade Transition
     *
     * @param rootView Scene root.
     */
    @SuppressLint(NEW_API)
    public static void captureTransitionFade(ViewGroup rootView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            TransitionManager.beginDelayedTransition(rootView, new Fade());
        }
    }
}
