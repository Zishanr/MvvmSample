package com.droid.nav.mvvmexample.view.ui;

import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.droid.nav.mvvmexample.R;
import com.droid.nav.mvvmexample.service.model.Project;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector,LifecycleOwner {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add project list fragment if this is first creation
        if (savedInstanceState == null) {
            ProjectListFragment fragment = new ProjectListFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment, ProjectListFragment.TAG).commit();
        }
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

}


/**
 * Shows the project detail fragment
 */
//    public void show(Project project) {
//        ProjectFragment projectFragment = ProjectFragment.forProject(project.name);
//
//        getSupportFragmentManager()
//                .beginTransaction()
//                .addToBackStack("project")
//                .replace(R.id.fragment_container,
//                        projectFragment, null).commit();
//    }
//}
