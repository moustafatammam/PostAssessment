package com.projects.android.domain.executor;

import io.reactivex.Scheduler;

/* a thread abstraction that uses a scheduler to do operation on observables in different threads
i will use it to get AndroidSchedular to bring the execution to the main thread
 */
public interface PostExecutionThread {

    Scheduler getScheduler();
}
