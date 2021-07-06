package com.test.stack.di;

import com.test.stack.home.HomeActivity;
import com.test.stack.home.HomeActivityModule;
import com.test.stack.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Activity builder class that maps all activities in graph using dagger.
 */
@Module
abstract class ActivityBuilderModule {
    @PerActivity
    @ContributesAndroidInjector(modules = {HomeActivityModule.class})
    abstract HomeActivity bindHomeActivity();

    @PerActivity
    @ContributesAndroidInjector
    abstract SplashActivity bindSplashActivity();

}
