package com.projects.android.presentation.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.projects.android.domain.useCases.impl.AddPostUseCase;
import com.projects.android.domain.useCases.impl.GetCountUseCase;
import com.projects.android.presentation.mapper.PresenterMapperImpl;
import com.projects.android.presentation.model.PresenterPost;

import javax.inject.Inject;

import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableObserver;

public class AddPostViewModel extends ViewModel {

    private AddPostUseCase mAddPostUseCase;
    private PresenterMapperImpl mPresenterMapperImpl;

    private MutableLiveData<String> addPostCompletableLiveData = new MutableLiveData<>();
    private MutableLiveData<Integer> getCountLiveData = new MutableLiveData<>();

    private GetCountUseCase getCountUseCase;


    @Inject
    public AddPostViewModel(AddPostUseCase mAddPostUseCase, GetCountUseCase getCountUseCase, PresenterMapperImpl mPresenterMapperImpl) {
        this.mAddPostUseCase = mAddPostUseCase;
        this.getCountUseCase = getCountUseCase;
        this.mPresenterMapperImpl = mPresenterMapperImpl;
        execute();
    }

    public LiveData<String> addPost(PresenterPost presenterPost){
        mAddPostUseCase.execute(new AddPostCompletable(), mPresenterMapperImpl.mapFromPresenterModel(presenterPost));
        return addPostCompletableLiveData;
    }

    public void execute(){
        getCountUseCase.execute(new GetCountObserver(), null);
    }

    public MutableLiveData<Integer> getGetCountLiveData() {
        return getCountLiveData;
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
            Log.e("AddPostViewModel", e.getMessage());
        }
    }

    class GetCountObserver extends DisposableObserver<Integer> {

        @Override
        public void onComplete() {
        }

        @Override
        public void onNext(Integer integer) {
            getCountLiveData.postValue(integer);
        }

        @Override
        public void onError(Throwable e) {
            Log.e("AddPostViewModel", e.getMessage());
        }
    }
}
