package com.projects.android.domain.useCases.base;

import com.projects.android.domain.executor.PostExecutionThread;
import com.projects.android.domain.executor.ThreadExecutor;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/*abstract useCase that returns a completable
each implementation will return the result using DisposableObserver, it will execute in a background thread
and post the result in the ui thread
 */
public abstract class AbstractObservableUseCase<T, Params> {

    private final ThreadExecutor mThreadThreadExecutor;
    private final PostExecutionThread mPostExecutionThread;
    private final CompositeDisposable mCompositeDisposable;

    public AbstractObservableUseCase(ThreadExecutor mThreadThreadExecutor
            , PostExecutionThread mPostExecutionThread) {
        this.mThreadThreadExecutor = mThreadThreadExecutor;
        this.mPostExecutionThread = mPostExecutionThread;
        this.mCompositeDisposable = new CompositeDisposable();
    }


    //builds a useCase that will return an Observable
    public abstract Observable<T> buildObservableUseCase(Params params);

    //executes the current useCase
    public void execute(DisposableObserver<T> observer, Params params){
        if (observer == null){
            throw new NullPointerException();
        }
        final Observable<T> observable = this.buildObservableUseCase(params)
                .subscribeOn(Schedulers.from(mThreadThreadExecutor))
                .observeOn(mPostExecutionThread.getScheduler());
        addDisposable(observable.subscribeWith(observer));
    }


    // disposes from the current compositeDisposable
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
