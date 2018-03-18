package com.droid.nav.mvvmexample.di;

import com.droid.nav.mvvmexample.view.ui.ProjectListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Copyright © 2017 Appster LLP. All rights reserved.
 * Created by navdeepbedi on 18/03/18.
 */

@Module
public abstract class FragmentBuildersModule {


    @ContributesAndroidInjector
    abstract ProjectListFragment contributeProjectListFragment();
}
