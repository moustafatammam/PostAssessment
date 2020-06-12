package com.projects.android.presentation.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.projects.android.domain.useCases.impl.UpdatePostUseCase;
import com.projects.android.presentation.mapper.PresenterMapperImpl;
import com.projects.android.presentation.model.PresenterPost;

import javax.inject.Inject;

import io.reactivex.observers.DisposableCompletableObserver;

public class UpdatePostViewModel extends ViewModel {

    private UpdatePostUseCase mUpdatePostUseCase;
    private PresenterMapperImpl mPresenterMapperImpl;

    private MutableLiveData<String> updatePostCompletableLiveData = new MutableLiveData<>();

    @Inject
    public UpdatePostViewModel(UpdatePostUseCase mUpdatePostUseCase, PresenterMapperImpl mPresenterMapperImpl) {
        this.mUpdatePostUseCase = mUpdatePostUseCase;
        this.mPresenterMapperImpl = mPresenterMapperImpl;
    }

    public LiveData<String> updatePost(PresenterPost presenterPost){
        mUpdatePostUseCase.execute(new UpdatePostCompletable(), mPresenterMapperImpl.mapFromPresenterModel(presenterPost));
        return updatePostCompletableLiveData;
    }

    @Override
    protected void onCleared() {
        mUpdatePostUseCase.dispose();
        super.onCleared();
    }

    class UpdatePostCompletable extends DisposableCompletableObserver{

        @Override
        public void onComplete() {
            String updateToastMsg = "Post updated successfully";
            Log.d("update", "done");
            updatePostCompletableLiveData.postValue(updateToastMsg);
            Log.d("update", "done");
        }

        @Override
        public void onError(Throwable e) {
            Log.d("update", e.getMessage());
        }
    }
}
