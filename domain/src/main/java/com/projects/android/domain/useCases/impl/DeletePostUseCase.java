package com.projects.android.domain.useCases.impl;

import com.projects.android.domain.executor.PostExecutionThread;
import com.projects.android.domain.executor.ThreadExecutor;
import com.projects.android.domain.model.Post;
import com.projects.android.domain.repository.PostRepository;
import com.projects.android.domain.useCases.base.AbstractCompletableUseCase;

import javax.inject.Inject;

import io.reactivex.Completable;

//useCase implementation to delete a post from PostRepository
public class DeletePostUseCase extends AbstractCompletableUseCase<Post> {

    private PostRepository mPostRepository;

    @Inject
    public DeletePostUseCase(PostRepository mPostRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread){
        super(threadExecutor, postExecutionThread);
        this.mPostRepository = mPostRepository;
    }


    /**
     *
     * @param post the model that will be deleted from the server and the database
     * @return a completable that check if the task is completed
     */
    @Override
    public Completable buildCompletableUseCase(Post post) {
        return mPostRepository.delete(post);
    }
}
