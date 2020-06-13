package com.projects.android.domain.useCases.impl;

import android.util.Log;

import com.projects.android.domain.executor.PostExecutionThread;
import com.projects.android.domain.executor.ThreadExecutor;
import com.projects.android.domain.model.Post;
import com.projects.android.domain.repository.PostRepository;
import com.projects.android.domain.useCases.base.AbstractObservableUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


//useCase implementation to retrieve list of posts from PostRepository
public class GetAllPostsUseCase extends AbstractObservableUseCase<List<Post>, Void> {

    private PostRepository mPostRepository;

    @Inject
    public GetAllPostsUseCase(PostRepository mPostRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread){
        super(threadExecutor, postExecutionThread);
        this.mPostRepository = mPostRepository;
    }

    /**
     *
     * @param aVoid this use case does not need params
     * @return list of model post that is wrapped in an observable
     */
    @Override
    public Observable<List<Post>> buildObservableUseCase(Void aVoid) {
        return mPostRepository.getAllPosts();
    }
}
