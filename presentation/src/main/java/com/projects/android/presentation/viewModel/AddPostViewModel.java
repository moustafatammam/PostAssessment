package com.projects.android.presentation.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.projects.android.domain.useCases.impl.AddPostUseCase;
import com.projects.android.presentation.mapper.PresenterMapperImpl;
import com.projects.android.presentation.model.PresenterPost;

import javax.inject.Inject;

import io.reactivex.observers.DisposableCompletableObserver;

public class AddPostViewModel extends ViewModel {

    private AddPostUseCase mAddPostUseCase;
    private PresenterMapperImpl mPresenterMapperImpl;

    private MutableLiveData<String> addPostCompletableLiveData = new MutableLiveData<>();

    @Inject
    public AddPostViewModel(AddPostUseCase mAddPostUseCase, PresenterMapperImpl mPresenterMapperImpl) {
        this.mAddPostUseCase = mAddPostUseCase;
        this.mPresenterMapperImpl = mPresenterMapperImpl;
    }

    public LiveData<String> addPost(PresenterPost presenterPost){
        mAddPostUseCase.execute(new AddPostCompletable(), mPresenterMapperImpl.mapFromPresenterModel(presenterPost));
        return addPostCompletableLiveData;
    }

    @Override
    protected void onCleared() {
        mAddPostUseCase.dispose();
        super.onCleared();
    }

    class AddPostCompletable extends DisposableCompletableObserver{

        @Override
        public void onComplete() {
            String addToastMsg = "Post Added Successfully";
            addPostCompletableLiveData.postValue(addToastMsg);

        }

        @Override
        public void onError(Throwable e) {

        }
    }
}
