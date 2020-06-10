package com.projects.android.presentation.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.projects.android.domain.useCases.impl.DeletePostUseCase;
import com.projects.android.presentation.mapper.PresenterMapperImpl;
import com.projects.android.presentation.model.PresenterPost;

import javax.inject.Inject;

import io.reactivex.observers.DisposableCompletableObserver;

public class DeletePostViewModel extends ViewModel {

    private DeletePostUseCase mDeletePostUseCase;
    private PresenterMapperImpl mPresenterMapperImpl;

    private MutableLiveData<String> deletePostCompletableLiveData = new MutableLiveData<>();

    @Inject
    public DeletePostViewModel(DeletePostUseCase mDeletePostUseCase, PresenterMapperImpl mPresenterMapperImpl) {
        this.mDeletePostUseCase = mDeletePostUseCase;
        this.mPresenterMapperImpl = mPresenterMapperImpl;
    }

    public LiveData<String> deletePost(PresenterPost presenterPost){
        mDeletePostUseCase.execute(new DeletePostCompletable(), mPresenterMapperImpl.mapFromPresenterModel(presenterPost));
        return deletePostCompletableLiveData;
    }

    @Override
    protected void onCleared() {
        mDeletePostUseCase.dispose();
        super.onCleared();
    }

    class DeletePostCompletable extends DisposableCompletableObserver{

        @Override
        public void onComplete() {
            String deleteToastMsg = "Post was deleted successfully";
            deletePostCompletableLiveData.postValue(deleteToastMsg);
        }

        @Override
        public void onError(Throwable e) {

        }
    }
}
