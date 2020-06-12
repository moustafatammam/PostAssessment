package com.projects.android.postassessment.di.module;

import com.projects.android.data.repository.PostRemote;
import com.projects.android.remote.PostClient;
import com.projects.android.remote.PostRemoteImpl;
import com.projects.android.remote.PostService;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class RemoteModule {

    @Provides
    public static PostService providePostService(){
        return PostClient.getServiecInstance();
    }

    @Binds
    public abstract PostRemote bindPostRemote(PostRemoteImpl postRemoteImpl);
}
