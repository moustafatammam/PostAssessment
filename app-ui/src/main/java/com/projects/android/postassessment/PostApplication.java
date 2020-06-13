package com.projects.android.postassessment;

import android.app.Application;

import com.projects.android.postassessment.di.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

public class PostApplication extends Application implements HasAndroidInjector {

    /**
     * this field help me create a SubComponent for the activity
     */
    @Inject
    DispatchingAndroidInjector<Object> activityDispatchingAndroidInjector;


    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApplicationComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }




    @Override
    public AndroidInjector androidInjector() {
        return activityDispatchingAndroidInjector;
    }
}
