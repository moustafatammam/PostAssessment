package com.projects.android.domain.useCases.base;

import android.util.Log;

import com.projects.android.domain.executor.PostExecutionThread;
import com.projects.android.domain.executor.ThreadExecutor;

import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;


//abstract useCase that returns a completable
public abstract class AbstractCompletableUseCase<Params> {

    private final ThreadExecutor mThreadThreadExecutor;
    private final PostExecutionThread mPostExecutionThread;
    private final CompositeDisposable mCompositeDisposable;

    public AbstractCompletableUseCase(ThreadExecutor mThreadThreadExecutor, PostExecutionThread mPostExecutionThread){
        this.mThreadThreadExecutor = mThreadThreadExecutor;
        this.mPostExecutionThread = mPostExecutionThread;
        this.mCompositeDisposable = new CompositeDisposable();
    }

    //builds a completable when the useCase is used
    public abstract Completable buildCompletableUseCase(Params params);


    //executes the current useCase
    public void execute(DisposableCompletableObserver observer, Params params){
        if (observer == null){
            throw new NullPointerException();
        }
        final Completable observable = this.buildCompletableUseCase(params)
                .subscribeOn(Schedulers.from(mThreadThreadExecutor))
                .observeOn(mPostExecutionThread.getScheduler());
        Log.d("usecase", "2");
        addDisposable(observable.subscribeWith(observer));
    }

    //disposes from the compositeDisposable
    public void dispose(){
        if(!mCompositeDisposable.isDisposed()){
            mCompositeDisposable.dispose();
        }
    }

    private void addDisposable(Disposable disposable){
        if(disposable == null){
            throw new NullPointerException();
        }else if (mCompositeDisposable == null){
            throw new NullPointerException();
        }
        mCompositeDisposable.add(disposable);
    }
}
