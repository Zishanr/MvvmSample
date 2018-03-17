package com.droid.nav.mvvmexample.view.ui;


import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.droid.nav.mvvmexample.R;
import com.droid.nav.mvvmexample.databinding.FragmentProjectListBinding;
import com.droid.nav.mvvmexample.service.model.Project;
import com.droid.nav.mvvmexample.view.adapter.ProjectAdapter;
import com.droid.nav.mvvmexample.view.callback.ProjectClickCallback;
import com.droid.nav.mvvmexample.viewmodel.ProjectListViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectListFragment extends Fragment {


    public static String TAG="PROJECTLIST";
    private FragmentProjectListBinding binding;
    private ProjectAdapter projectAdapter;
    ViewModelProvider.Factory viewModelFactory;


    public ProjectListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_project_list, container, false);

        projectAdapter = new ProjectAdapter(projectClickCallback);
        binding.projectList.setAdapter(projectAdapter);
        binding.setIsLoading(true);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModelFactory=new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication());
        final ProjectListViewModel viewModel =
                ViewModelProviders.of(this,viewModelFactory).get(ProjectListViewModel.class);

        observeViewModel(viewModel);
    }

    private void observeViewModel(ProjectListViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getProjectListObservable().observe(this, new Observer<List<Project>>() {
            @Override
            public void onChanged(@Nullable List<Project> projects) {
                if (projects != null) {
                    binding.setIsLoading(false);
                    projectAdapter.setProjectList(projects);
                }
            }
        });
    }

    private ProjectClickCallback projectClickCallback=new ProjectClickCallback() {
        @Override
        public void onClick(Project project) {

        }
    };




}
