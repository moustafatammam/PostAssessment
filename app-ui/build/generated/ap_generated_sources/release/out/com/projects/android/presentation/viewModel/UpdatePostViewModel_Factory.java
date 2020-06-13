package com.projects.android.presentation.viewModel;

import com.projects.android.domain.useCases.impl.UpdatePostUseCase;
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
public final class UpdatePostViewModel_Factory implements Factory<UpdatePostViewModel> {
  private final Provider<UpdatePostUseCase> mUpdatePostUseCaseProvider;

  private final Provider<PresenterMapperImpl> mPresenterMapperImplProvider;

  public UpdatePostViewModel_Factory(Provider<UpdatePostUseCase> mUpdatePostUseCaseProvider,
      Provider<PresenterMapperImpl> mPresenterMapperImplProvider) {
    this.mUpdatePostUseCaseProvider = mUpdatePostUseCaseProvider;
    this.mPresenterMapperImplProvider = mPresenterMapperImplProvider;
  }

  @Override
  public UpdatePostViewModel get() {
    return new UpdatePostViewModel(mUpdatePostUseCaseProvider.get(), mPresenterMapperImplProvider.get());
  }

  public static UpdatePostViewModel_Factory create(
      Provider<UpdatePostUseCase> mUpdatePostUseCaseProvider,
      Provider<PresenterMapperImpl> mPresenterMapperImplProvider) {
    return new UpdatePostViewModel_Factory(mUpdatePostUseCaseProvider, mPresenterMapperImplProvider);
  }

  public static UpdatePostViewModel newInstance(UpdatePostUseCase mUpdatePostUseCase,
      PresenterMapperImpl mPresenterMapperImpl) {
    return new UpdatePostViewModel(mUpdatePostUseCase, mPresenterMapperImpl);
  }
}
