package com.projects.android.presentation.viewModel;

import com.projects.android.domain.useCases.impl.GetAllPostsUseCase;
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
public final class GetAllPostsViewModel_Factory implements Factory<GetAllPostsViewModel> {
  private final Provider<GetAllPostsUseCase> mGetAllPostsUseCaseProvider;

  private final Provider<PresenterMapperImpl> mPresenterMapperImplProvider;

  public GetAllPostsViewModel_Factory(Provider<GetAllPostsUseCase> mGetAllPostsUseCaseProvider,
      Provider<PresenterMapperImpl> mPresenterMapperImplProvider) {
    this.mGetAllPostsUseCaseProvider = mGetAllPostsUseCaseProvider;
    this.mPresenterMapperImplProvider = mPresenterMapperImplProvider;
  }

  @Override
  public GetAllPostsViewModel get() {
    return new GetAllPostsViewModel(mGetAllPostsUseCaseProvider.get(), mPresenterMapperImplProvider.get());
  }

  public static GetAllPostsViewModel_Factory create(
      Provider<GetAllPostsUseCase> mGetAllPostsUseCaseProvider,
      Provider<PresenterMapperImpl> mPresenterMapperImplProvider) {
    return new GetAllPostsViewModel_Factory(mGetAllPostsUseCaseProvider, mPresenterMapperImplProvider);
  }

  public static GetAllPostsViewModel newInstance(GetAllPostsUseCase mGetAllPostsUseCase,
      PresenterMapperImpl mPresenterMapperImpl) {
    return new GetAllPostsViewModel(mGetAllPostsUseCase, mPresenterMapperImpl);
  }
}
