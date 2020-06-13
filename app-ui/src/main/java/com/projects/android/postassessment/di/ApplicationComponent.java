package com.projects.android.postassessment.di;


import android.app.Application;

import com.projects.android.postassessment.PostApplication;
import com.projects.android.postassessment.di.module.AppUiModule;
import com.projects.android.postassessment.di.module.ApplicationModule;
import com.projects.android.postassessment.di.module.CacheModule;
import com.projects.android.postassessment.di.module.DataModule;
import com.projects.android.postassessment.di.module.FragmentModule;
import com.projects.android.postassessment.di.module.PreseneterModule;
import com.projects.android.postassessment.di.module.RemoteModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {ApplicationModule.class, CacheModule.class,
        DataModule.class, RemoteModule.class, PreseneterModule.class,
        AppUiModule.class, AndroidSupportInjectionModule.class, FragmentModule.class})
public interface ApplicationComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);
        ApplicationComponent build();
    }

    void inject(PostApplication app);
}
