package com.droid.nav.mvvmexample.di;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;

import com.droid.nav.mvvmexample.Application;
import com.droid.nav.mvvmexample.service.repository.GithubService;
import com.droid.nav.mvvmexample.viewmodel.ProjectViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Copyright © 2017 Appster LLP. All rights reserved.
 * Created by navdeepbedi on 18/03/18.
 */


@Module(subcomponents = ViewModelSubComponent.class)
public class AppModule {
    @Singleton @Provides
    GithubService provideGithubService() {
        return new Retrofit.Builder()
                .baseUrl(GithubService.HTTPS_API_GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService.class);
    }

    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(
            ViewModelSubComponent.Builder viewModelSubComponent) {

        return new ProjectViewModelFactory(viewModelSubComponent.build());
    }

}