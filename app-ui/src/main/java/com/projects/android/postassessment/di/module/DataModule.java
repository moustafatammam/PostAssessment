package com.projects.android.postassessment.di.module;

import com.projects.android.data.PostDataRepository;
import com.projects.android.data.executor.JobExecutor;
import com.projects.android.domain.executor.ThreadExecutor;
import com.projects.android.domain.repository.PostRepository;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DataModule {

    @Binds
    abstract PostRepository bindPostRepository(PostDataRepository postDataRepository);

    @Binds
    abstract ThreadExecutor bindThreadExecutor(JobExecutor jobExecutor);
}
