package com.droid.nav.mvvmexample.service.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.droid.nav.mvvmexample.service.model.Project;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Copyright © 2017 Appster LLP. All rights reserved.
 * Created by navdeepbedi on 17/03/18.
 */
@Singleton
public class ProjectRepository {

    private GithubService githubService;

    @Inject
    public ProjectRepository(GithubService gitHubService) {

        this.githubService=gitHubService;
//        githubService = new Retrofit.Builder()
//                .baseUrl(GithubService.HTTPS_API_GITHUB_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(GithubService.class);

    }


    public LiveData<List<Project>> getProjectList(String userId) {
        final MutableLiveData<List<Project>> data = new MutableLiveData<>();

        githubService.getProjectList(userId).enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {

                data.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {

            }
        });

        return data;
    }


}
