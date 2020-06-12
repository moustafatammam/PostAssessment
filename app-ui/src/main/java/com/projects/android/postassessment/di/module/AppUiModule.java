package com.projects.android.postassessment.di.module;

import com.projects.android.domain.executor.PostExecutionThread;
import com.projects.android.postassessment.UiThread;
import com.projects.android.postassessment.userInterface.PostCallBack;
import com.projects.android.postassessment.userInterface.PostListener;
import com.projects.android.postassessment.userInterface.activities.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AppUiModule {

    @Binds
    abstract PostExecutionThread bindPostExecutionThread(UiThread uiThread);



    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();
}
