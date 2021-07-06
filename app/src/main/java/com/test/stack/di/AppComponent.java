package com.test.stack.di;

import android.app.Application;

import com.test.stack.StackQuestionApp;
import com.squareup.moshi.Moshi;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * App component interface.
 */

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ApiModule.class,
        ActivityBuilderModule.class})
public interface AppComponent {

    /**
     * Binding application class instance to app component.
     */
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

    void inject(StackQuestionApp app);

    Moshi moshi();
}
