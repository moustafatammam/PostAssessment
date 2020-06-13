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
public final class GetAllPostsUseCase_Factory implements Factory<GetAllPostsUseCase> {
  private final Provider<PostRepository> mPostRepositoryProvider;

  private final Provider<ThreadExecutor> threadExecutorProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetAllPostsUseCase_Factory(Provider<PostRepository> mPostRepositoryProvider,
      Provider<ThreadExecutor> threadExecutorProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    this.mPostRepositoryProvider = mPostRepositoryProvider;
    this.threadExecutorProvider = threadExecutorProvider;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetAllPostsUseCase get() {
    return new GetAllPostsUseCase(mPostRepositoryProvider.get(), threadExecutorProvider.get(), postExecutionThreadProvider.get());
  }

  public static GetAllPostsUseCase_Factory create(Provider<PostRepository> mPostRepositoryProvider,
      Provider<ThreadExecutor> threadExecutorProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetAllPostsUseCase_Factory(mPostRepositoryProvider, threadExecutorProvider, postExecutionThreadProvider);
  }

  public static GetAllPostsUseCase newInstance(PostRepository mPostRepository,
      ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
    return new GetAllPostsUseCase(mPostRepository, threadExecutor, postExecutionThread);
  }
}
