package com.projects.android.postassessment;

import com.projects.android.domain.executor.PostExecutionThread;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * a class to post data to the UI Thread
 */
public class UiThread implements PostExecutionThread {

    @Inject
    public UiThread() {
    }

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
