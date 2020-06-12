package com.projects.android.postassessment.di.module;

import android.app.Application;

import androidx.room.Room;

import com.projects.android.cache.PostCacheImpl;
import com.projects.android.cache.database.PostDatabase;
import com.projects.android.data.repository.PostCache;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class CacheModule {

    @Provides
    public static PostDatabase providePostApplication(Application application){
        return Room.databaseBuilder(application.getApplicationContext(),
                PostDatabase.class, "PostDatabase").build();
    }

    @Binds
    public abstract PostCache bindPostCache(PostCacheImpl postCacheImpl);
}
