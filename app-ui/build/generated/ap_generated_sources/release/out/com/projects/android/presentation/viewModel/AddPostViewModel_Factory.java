package com.projects.android.presentation.viewModel;

import com.projects.android.domain.useCases.impl.AddPostUseCase;
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
public final class AddPostViewModel_Factory implements Factory<AddPostViewModel> {
  private final Provider<AddPostUseCase> mAddPostUseCaseProvider;

  private final Provider<PresenterMapperImpl> mPresenterMapperImplProvider;

  public AddPostViewModel_Factory(Provider<AddPostUseCase> mAddPostUseCaseProvider,
      Provider<PresenterMapperImpl> mPresenterMapperImplProvider) {
    this.mAddPostUseCaseProvider = mAddPostUseCaseProvider;
    this.mPresenterMapperImplProvider = mPresenterMapperImplProvider;
  }

  @Override
  public AddPostViewModel get() {
    return new AddPostViewModel(mAddPostUseCaseProvider.get(), mPresenterMapperImplProvider.get());
  }

  public static AddPostViewModel_Factory create(Provider<AddPostUseCase> mAddPostUseCaseProvider,
      Provider<PresenterMapperImpl> mPresenterMapperImplProvider) {
    return new AddPostViewModel_Factory(mAddPostUseCaseProvider, mPresenterMapperImplProvider);
  }

  public static AddPostViewModel newInstance(AddPostUseCase mAddPostUseCase,
      PresenterMapperImpl mPresenterMapperImpl) {
    return new AddPostViewModel(mAddPostUseCase, mPresenterMapperImpl);
  }
}
