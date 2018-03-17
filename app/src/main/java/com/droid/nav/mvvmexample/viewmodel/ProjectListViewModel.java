package com.droid.nav.mvvmexample.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.droid.nav.mvvmexample.service.model.Project;
import com.droid.nav.mvvmexample.service.repository.ProjectRepository;

import java.util.List;

/**
 * Copyright © 2017 Appster LLP. All rights reserved.
 * Created by navdeepbedi on 17/03/18.
 */

public class ProjectListViewModel extends AndroidViewModel {

    private final LiveData<List<Project>> projectListObservable;

    public ProjectListViewModel(Application application) {
        super(application);
        ProjectRepository projectRepository=new ProjectRepository();
        this.projectListObservable = projectRepository.getProjectList("Google");
    }

    public LiveData<List<Project>> getProjectListObservable() {
        return projectListObservable;
    }
}
