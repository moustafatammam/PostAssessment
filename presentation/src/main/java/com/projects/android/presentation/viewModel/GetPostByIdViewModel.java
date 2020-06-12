package com.projects.android.presentation.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.projects.android.domain.model.Post;
import com.projects.android.domain.useCases.impl.GetPostByIdUseCase;
import com.projects.android.presentation.mapper.PresenterMapperImpl;
import com.projects.android.presentation.model.PresenterPost;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

public class GetPostByIdViewModel extends ViewModel {

    private GetPostByIdUseCase mGetPostByIdUseCase;
    private PresenterMapperImpl mPresenterMapperImpl;

    public MutableLiveData<PresenterPost> postLiveData = new MutableLiveData<>();


    @Inject
    public GetPostByIdViewModel(GetPostByIdUseCase mGetPostByIdUseCase, PresenterMapperImpl mPresenterMapperImpl) {
        this.mGetPostByIdUseCase = mGetPostByIdUseCase;
        this.mPresenterMapperImpl = mPresenterMapperImpl;
    }

    public LiveData<PresenterPost> getPostByIdLiveData(int id){
        mGetPostByIdUseCase.execute(new GetPostByIdObserver(), id);
        return postLiveData;
    }


    @Override
    protected void onCleared() {
        mGetPostByIdUseCase.dispose();
        super.onCleared();
    }

    class GetPostByIdObserver extends DisposableObserver<Post>{

        @Override
        public void onNext(Post post) {
            postLiveData.postValue(mPresenterMapperImpl.mapToPresenterModel(post));
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }
}
