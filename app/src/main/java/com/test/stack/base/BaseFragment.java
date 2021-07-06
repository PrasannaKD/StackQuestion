package com.test.stack.base;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.test.stack.R;

import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;

/**
 * Base fragment class that any fragment can extends.
 */
public abstract class BaseFragment extends Fragment implements MvpView {

    @Nullable
    private Unbinder viewUnbinder;

    private BaseActivity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            AndroidSupportInjection.inject(this);
        }
        if (activity instanceof BaseActivity) {
            this.mActivity = (BaseActivity) activity;
        }
        super.onAttach(activity);
    }

    @Override
    public void onAttach(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            AndroidSupportInjection.inject(this);
        }
        if (context instanceof BaseActivity) {
            this.mActivity = (BaseActivity) context;
        }
        super.onAttach(context);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpView(view);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        // good to use here too.
        //viewUnbinder = ButterKnife.bind(this, getView());
    }

    @Override
    public void onDestroyView() {
        if (viewUnbinder != null) {
            viewUnbinder.unbind();
        }
        mActivity = null;
        super.onDestroyView();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(@StringRes int resId) {

    }

    @Override
    public void onError(String message) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getBaseActivity())
                .setTitle(R.string.error)
                .setMessage(message)
                .setPositiveButton(R.string.ok, (dialog, which) -> dialog.dismiss())
                .setCancelable(true);
        dialogBuilder.show();
    }

    @Override
    public void showMessage(@StringRes int resId) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void hideKeyboard() {

    }

    protected abstract void setUpView(View view);

    public void setViewUnbinder(Unbinder unbinder) {
        viewUnbinder = unbinder;
    }

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }
}
