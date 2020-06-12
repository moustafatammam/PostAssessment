package com.projects.android.domain.useCases.impl;

import com.projects.android.domain.executor.PostExecutionThread;
import com.projects.android.domain.executor.ThreadExecutor;
import com.projects.android.domain.model.Post;
import com.projects.android.domain.repository.PostRepository;
import com.projects.android.domain.useCases.base.AbstractObservableUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetCountUseCase extends AbstractObservableUseCase<Integer, Void> {

    private PostRepository mPostRepository;

    @Inject
    public GetCountUseCase(PostRepository mPostRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread){
        super(threadExecutor, postExecutionThread);
        this.mPostRepository = mPostRepository;
    }

    @Override
    public Observable<Integer> buildObservableUseCase(Void aVoid) {
        return mPostRepository.getCount();
    }
}
