package com.test.stack.home;


import com.test.stack.common.CommonPresenter;
import com.test.stack.common.CommonPresenterImpl;
import com.test.stack.common.CommonView;
import com.test.stack.di.PerFragment;
import com.test.stack.home.feed.FeaturedFeedFragment;
import com.test.stack.home.feed.FeedView;
import com.test.stack.home.feed.FeedViewPresenter;
import com.test.stack.home.feed.FeedViewPresenterImpl;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Activity module for home activity.
 */
@Module
public abstract class HomeActivityModule {

    @PerFragment
    @ContributesAndroidInjector
    abstract FeaturedFeedFragment provideFeaturedFeedFragmentFactory();


    @Binds
    abstract FeedViewPresenter<FeedView> provideFeedViewPresenter(FeedViewPresenterImpl<FeedView>
                                                                          feedViewPresenterImpl);

    @Binds
    abstract CommonPresenter<CommonView> provideCommonPresenter(CommonPresenterImpl<CommonView>
                                                                        commonPresenterImpl);
}
