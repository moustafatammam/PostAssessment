package com.projects.android.domain.useCases.impl;

import android.util.Log;

import com.projects.android.domain.executor.PostExecutionThread;
import com.projects.android.domain.executor.ThreadExecutor;
import com.projects.android.domain.model.Post;
import com.projects.android.domain.repository.PostRepository;
import com.projects.android.domain.useCases.base.AbstractCompletableUseCase;

import javax.inject.Inject;

import io.reactivex.Completable;

//useCase implementation to add a post to PostRepository
public class AddPostUseCase extends AbstractCompletableUseCase<Post> {

    private PostRepository mPostRepository;

    @Inject
    public AddPostUseCase(PostRepository mPostRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread){
        super(threadExecutor, postExecutionThread);
        this.mPostRepository = mPostRepository;
    }

    @Override
    public Completable buildCompletableUseCase(Post post) {
        Log.d("usecase", "1");
        return mPostRepository.insert(post);
    }
}
