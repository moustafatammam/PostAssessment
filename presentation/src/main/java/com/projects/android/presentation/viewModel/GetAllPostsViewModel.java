package com.projects.android.presentation.viewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.projects.android.domain.model.Post;
import com.projects.android.domain.useCases.impl.GetAllPostsUseCase;
import com.projects.android.presentation.mapper.PresenterMapperImpl;
import com.projects.android.presentation.model.PresenterPost;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

public class GetAllPostsViewModel extends ViewModel {

    private GetAllPostsUseCase mGetAllPostsUseCase;
    private PresenterMapperImpl mPresenterMapperImpl;

    private MutableLiveData<List<PresenterPost>> postListLiveData = new MutableLiveData<>();
    private MutableLiveData<Integer> count = new MutableLiveData<>();

    @Inject
    public GetAllPostsViewModel(GetAllPostsUseCase mGetAllPostsUseCase, PresenterMapperImpl mPresenterMapperImpl) {
        this.mGetAllPostsUseCase = mGetAllPostsUseCase;
        this.mPresenterMapperImpl = mPresenterMapperImpl;
        executeUseCase();
    }

    private void executeUseCase(){
        mGetAllPostsUseCase.execute(new GetAllPostsObserver(), null);
    }


    public MutableLiveData<List<PresenterPost>> getPostListLiveData() {
        return postListLiveData;
    }

    @Override
    protected void onCleared() {
        mGetAllPostsUseCase.dispose();
        super.onCleared();
    }

    class GetAllPostsObserver extends DisposableObserver<List<Post>>{

        @Override
        public void onNext(List<Post> posts) {
            List<PresenterPost> prePostList = posts.stream().map(post -> mPresenterMapperImpl.mapToPresenterModel(post))
                    .collect(Collectors.toList());
            postListLiveData.postValue(prePostList);

        }

        @Override
        public void onError(Throwable e) {
            Log.e("GetAllPostsViewModel", e.getMessage());
        }

        @Override
        public void onComplete() {
            Log.d("GetAllPostsViewModel", "completed");

        }
    }
}
