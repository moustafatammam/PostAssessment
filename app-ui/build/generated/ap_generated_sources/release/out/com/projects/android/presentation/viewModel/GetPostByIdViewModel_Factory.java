package com.projects.android.presentation.viewModel;

import com.projects.android.domain.useCases.impl.GetPostByIdUseCase;
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
public final class GetPostByIdViewModel_Factory implements Factory<GetPostByIdViewModel> {
  private final Provider<GetPostByIdUseCase> mGetPostByIdUseCaseProvider;

  private final Provider<PresenterMapperImpl> mPresenterMapperImplProvider;

  public GetPostByIdViewModel_Factory(Provider<GetPostByIdUseCase> mGetPostByIdUseCaseProvider,
      Provider<PresenterMapperImpl> mPresenterMapperImplProvider) {
    this.mGetPostByIdUseCaseProvider = mGetPostByIdUseCaseProvider;
    this.mPresenterMapperImplProvider = mPresenterMapperImplProvider;
  }

  @Override
  public GetPostByIdViewModel get() {
    return new GetPostByIdViewModel(mGetPostByIdUseCaseProvider.get(), mPresenterMapperImplProvider.get());
  }

  public static GetPostByIdViewModel_Factory create(
      Provider<GetPostByIdUseCase> mGetPostByIdUseCaseProvider,
      Provider<PresenterMapperImpl> mPresenterMapperImplProvider) {
    return new GetPostByIdViewModel_Factory(mGetPostByIdUseCaseProvider, mPresenterMapperImplProvider);
  }

  public static GetPostByIdViewModel newInstance(GetPostByIdUseCase mGetPostByIdUseCase,
      PresenterMapperImpl mPresenterMapperImpl) {
    return new GetPostByIdViewModel(mGetPostByIdUseCase, mPresenterMapperImpl);
  }
}
