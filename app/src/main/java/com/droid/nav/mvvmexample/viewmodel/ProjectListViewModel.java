package com.droid.nav.mvvmexample.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.droid.nav.mvvmexample.service.model.Project;
import com.droid.nav.mvvmexample.service.repository.ProjectRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Copyright © 2017 Appster LLP. All rights reserved.
 * Created by navdeepbedi on 17/03/18.
 */

public class ProjectListViewModel extends AndroidViewModel {

    private final LiveData<List<Project>> projectListObservable;


    @Inject
    public ProjectListViewModel(@NonNull ProjectRepository projectRepository, @NonNull Application application) {
        super(application);

        // If any transformation is needed, this can be simply done by Transformations class ...
        projectListObservable = projectRepository.getProjectList("Google");
    }
//
//    public ProjectListViewModel(Application application) {
//        super(application);
//        this.projectListObservable = projectRepository.getProjectList("Google");
//    }

    public LiveData<List<Project>> getProjectListObservable() {
        return projectListObservable;
    }
}
