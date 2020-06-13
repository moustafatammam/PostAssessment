package com.projects.android.domain.useCases.impl;

import com.projects.android.domain.executor.PostExecutionThread;
import com.projects.android.domain.executor.ThreadExecutor;
import com.projects.android.domain.model.Post;
import com.projects.android.domain.repository.PostRepository;
import com.projects.android.domain.useCases.base.AbstractCompletableUseCase;

import javax.inject.Inject;

import io.reactivex.Completable;

//useCase implementation to update a post in PostRepository
public class UpdatePostUseCase extends AbstractCompletableUseCase<Post> {

    private PostRepository mPostRepository;

    @Inject
    public UpdatePostUseCase(PostRepository mPostRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread){
        super(threadExecutor, postExecutionThread);
        this.mPostRepository = mPostRepository;
    }

    /**
     *
     * @param post the post model that will be updated to the server and the database
     * @return ist of model post that is wrapped in an observable
     */
    @Override
    public Completable buildCompletableUseCase(Post post) {
        return mPostRepository.update(post);
    }
}
