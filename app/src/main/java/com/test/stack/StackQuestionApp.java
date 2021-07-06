package com.test.stack;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.test.stack.di.DaggerAppComponent;
import com.test.stack.log.TimberThreadDebugTree;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;

/**
 * Application class for StackQuestion app.
 */
public class StackQuestionApp extends Application implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        //init dagger injection
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);
        Timber.plant(new TimberThreadDebugTree());
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
