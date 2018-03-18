package com.droid.nav.mvvmexample.di;

import com.droid.nav.mvvmexample.viewmodel.ProjectListViewModel;

import dagger.Subcomponent;

/**
 * Copyright © 2017 Appster LLP. All rights reserved.
 * Created by navdeepbedi on 18/03/18.
 */

@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    ProjectListViewModel projectListViewModel();
}

