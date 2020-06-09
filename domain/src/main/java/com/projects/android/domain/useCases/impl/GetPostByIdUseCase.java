package com.projects.android.domain.useCases.impl;

import com.projects.android.domain.executor.PostExecutionThread;
import com.projects.android.domain.executor.ThreadExecutor;
import com.projects.android.domain.model.Post;
import com.projects.android.domain.repository.PostRepository;
import com.projects.android.domain.useCases.base.AbstractObservableUseCase;

import javax.inject.Inject;

import io.reactivex.Observable;

//useCase implementation to retrieve a single post by its Id from PostRepository
public class GetPostByIdUseCase extends AbstractObservableUseCase<Post, Integer> {

    private PostRepository mPostRepository;

    @Inject
    public GetPostByIdUseCase(PostRepository mPostRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread){
        super(threadExecutor, postExecutionThread);
        this.mPostRepository = mPostRepository;
    }

    @Override
    public Observable<Post> buildObservableUseCase(Integer postId) {
        return mPostRepository.getPostbyId(postId);
    }
}
