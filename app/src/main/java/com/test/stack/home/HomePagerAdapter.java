package com.test.stack.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.test.stack.home.feed.FeaturedFeedFragment;

/**
 * Pager adapter for home.
 */
public class HomePagerAdapter extends FragmentStatePagerAdapter {

    private final FeaturedFeedFragment featuredFeedFragment;

    /**
     * Constructor for home pager adapter.
     *
     * @param fm                   fragment manager instance.
     * @param featuredFeedFragment feed type featured instance.
     */
    HomePagerAdapter(FragmentManager fm,
                     FeaturedFeedFragment featuredFeedFragment) {
        super(fm);
        this.featuredFeedFragment = featuredFeedFragment;
    }

    @Override
    public Fragment getItem(int position) {
        return featuredFeedFragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "Features";
        return title;
    }

    @Override
    public int getCount() {
        return 1;
    }
}
