package com.projects.android.domain.useCases.base;

import com.projects.android.domain.executor.PostExecutionThread;
import com.projects.android.domain.executor.ThreadExecutor;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * @param <T>      the model type that the USeCAse will use when implementing this class
 * @param <Params> nthe params you will use to build the UseCase
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


    /**
     * @param params the params you will use to build the completable
     * @return an Observable to check if the task is done
     */
    public abstract Observable<T> buildObservableUseCase(Params params);

    /**
     * @param observer the observer that will subscribe to the Observable
     * @param params   the params you will use to build the Observable
     */
    public void execute(DisposableObserver<T> observer, Params params) {
        if (observer == null) {
            throw new NullPointerException();
        }
        final Observable<T> observable = this.buildObservableUseCase(params)
                .subscribeOn(Schedulers.from(mThreadThreadExecutor))
                .observeOn(mPostExecutionThread.getScheduler());
        addDisposable(observable.subscribeWith(observer));
    }


    /**
     * dispose of the compositeDisposable after finishing
     */
    public void dispose() {
        if (!mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.dispose();
        }
    }

    /**
     *
     * @param disposable a link between observable and its observer, is disposed after finishing
     */
    private void addDisposable(Disposable disposable) {
        if (disposable == null) {
            throw new NullPointerException();
        } else if (mCompositeDisposable == null) {
            throw new NullPointerException();
        }
        mCompositeDisposable.add(disposable);

    }
}
