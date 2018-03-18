package com.droid.nav.mvvmexample.di;

import com.droid.nav.mvvmexample.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Copyright © 2017 Appster LLP. All rights reserved.
 * Created by navdeepbedi on 18/03/18.
 */

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        MainActivityModule.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(android.app.Application application);
        AppComponent build();
    }

    void inject(Application application);
}
