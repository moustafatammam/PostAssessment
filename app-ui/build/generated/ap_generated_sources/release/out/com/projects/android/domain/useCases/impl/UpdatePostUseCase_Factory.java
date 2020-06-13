package com.projects.android.domain.useCases.impl;

import com.projects.android.domain.executor.PostExecutionThread;
import com.projects.android.domain.executor.ThreadExecutor;
import com.projects.android.domain.repository.PostRepository;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class UpdatePostUseCase_Factory implements Factory<UpdatePostUseCase> {
  private final Provider<PostRepository> mPostRepositoryProvider;

  private final Provider<ThreadExecutor> threadExecutorProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public UpdatePostUseCase_Factory(Provider<PostRepository> mPostRepositoryProvider,
      Provider<ThreadExecutor> threadExecutorProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.mPostRepositoryProvider = mPostRepositoryProvider;
    this.threadExecutorProvider = threadExecutorProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public UpdatePostUseCase get() {
    return new UpdatePostUseCase(mPostRepositoryProvider.get(), threadExecutorProvider.get(), postExecutionThreadProvider.get());
  }

  public static UpdatePostUseCase_Factory create(Provider<PostRepository> mPostRepositoryProvider,
      Provider<ThreadExecutor> threadExecutorProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new UpdatePostUseCase_Factory(mPostRepositoryProvider, threadExecutorProvider, postExecutionThreadProvider);
  }

  public static UpdatePostUseCase newInstance(PostRepository mPostRepository,
      ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
    return new UpdatePostUseCase(mPostRepository, threadExecutor, postExecutionThread);
  }
}
