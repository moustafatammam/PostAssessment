package com.projects.android.domain.useCases.impl;

import com.projects.android.domain.executor.PostExecutionThread;
import com.projects.android.domain.executor.ThreadExecutor;
import com.projects.android.domain.model.Post;
import com.projects.android.domain.repository.PostRepository;
import com.projects.android.domain.useCases.base.AbstractCompletableUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;


public class AddAllPostsUseCase extends AbstractCompletableUseCase<List<Post>> {

    private PostRepository mPostRepository;

    @Inject
    public AddAllPostsUseCase(PostRepository mPostRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread){
        super(threadExecutor, postExecutionThread);
        this.mPostRepository = mPostRepository;
    }


    /**
     *
     * @param posts the model that will be inserted to the database
     * @return a completable that check if the task is completed
     */
    @Override
    public Completable buildCompletableUseCase(List<Post> posts) {
        return mPostRepository.insertAll(posts);
    }
}
