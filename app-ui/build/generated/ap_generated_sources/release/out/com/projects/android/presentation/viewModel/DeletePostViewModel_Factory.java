package com.projects.android.presentation.viewModel;

import com.projects.android.domain.useCases.impl.DeletePostUseCase;
import com.projects.android.presentation.mapper.PresenterMapperImpl;
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
public final class DeletePostViewModel_Factory implements Factory<DeletePostViewModel> {
  private final Provider<DeletePostUseCase> mDeletePostUseCaseProvider;

  private final Provider<PresenterMapperImpl> mPresenterMapperImplProvider;

  public DeletePostViewModel_Factory(Provider<DeletePostUseCase> mDeletePostUseCaseProvider,
      Provider<PresenterMapperImpl> mPresenterMapperImplProvider) {
    this.mDeletePostUseCaseProvider = mDeletePostUseCaseProvider;
    this.mPresenterMapperImplProvider = mPresenterMapperImplProvider;
  }

  @Override
  public DeletePostViewModel get() {
    return new DeletePostViewModel(mDeletePostUseCaseProvider.get(), mPresenterMapperImplProvider.get());
  }

  public static DeletePostViewModel_Factory create(
      Provider<DeletePostUseCase> mDeletePostUseCaseProvider,
      Provider<PresenterMapperImpl> mPresenterMapperImplProvider) {
    return new DeletePostViewModel_Factory(mDeletePostUseCaseProvider, mPresenterMapperImplProvider);
  }

  public static DeletePostViewModel newInstance(DeletePostUseCase mDeletePostUseCase,
      PresenterMapperImpl mPresenterMapperImpl) {
    return new DeletePostViewModel(mDeletePostUseCase, mPresenterMapperImpl);
  }
}
