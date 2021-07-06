package com.test.stack.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.Toast;

import com.test.stack.AppConstants;
import com.test.stack.R;
import com.test.stack.base.BaseActivity;
import com.test.stack.home.feed.FeaturedFeedFragment;
import com.test.stack.rxevent.RxEventBus;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;

/**
 * MainActivity of StackQuestion app.
 */
public class HomeActivity extends BaseActivity {
    private static final String TAG = HomeActivity.class.getSimpleName();

    // injection
    @Inject
    RxEventBus eventBus;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.app_bar)
    AppBarLayout appBarLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.root)
    ViewGroup rootView;

    @Inject
    FeaturedFeedFragment featuredFeedFragment;


    private final CompositeDisposable disposables = new CompositeDisposable();
    private HomePagerAdapter homePagerAdapter;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setUpViewPager();
    }

    /**
     * Initializing view pager.
     */
    private void setUpViewPager() {
        featuredFeedFragment.setArguments(getFilterArgBundle(AppConstants.VOTES));

        homePagerAdapter = new HomePagerAdapter(getSupportFragmentManager(),
                featuredFeedFragment);
        viewPager.setAdapter(homePagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }

        });
        viewPager.setCurrentItem(0);
    }

    private Bundle getFilterArgBundle(String filterType) {
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.ARG_FILTER_TYPE, filterType);
        return bundle;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }


    @Override
    protected void onDestroy() {
        disposables.clear();
        super.onDestroy();
    }
}
