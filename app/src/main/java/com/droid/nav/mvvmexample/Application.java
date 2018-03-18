package com.droid.nav.mvvmexample;

import android.app.Activity;
import com.droid.nav.mvvmexample.di.AppInjector;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Copyright © 2017 Appster LLP. All rights reserved.
 * Created by navdeepbedi on 17/03/18.
 */

public class Application extends android.app.Application
        implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        AppInjector.init(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
