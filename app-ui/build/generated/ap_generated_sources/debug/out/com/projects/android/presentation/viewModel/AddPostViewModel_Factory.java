package com.projects.android.presentation.viewModel;

import com.projects.android.domain.useCases.impl.AddPostUseCase;
import com.projects.android.domain.useCases.impl.GetCountUseCase;
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

  private final Provider<GetCountUseCase> getCountUseCaseProvider;

  private final Provider<PresenterMapperImpl> mPresenterMapperImplProvider;

  public AddPostViewModel_Factory(Provider<AddPostUseCase> mAddPostUseCaseProvider,
      Provider<GetCountUseCase> getCountUseCaseProvider,
      Provider<PresenterMapperImpl> mPresenterMapperImplProvider) {
    this.mAddPostUseCaseProvider = mAddPostUseCaseProvider;
    this.getCountUseCaseProvider = getCountUseCaseProvider;
    this.mPresenterMapperImplProvider = mPresenterMapperImplProvider;
  }

  @Override
  public AddPostViewModel get() {
    return new AddPostViewModel(mAddPostUseCaseProvider.get(), getCountUseCaseProvider.get(), mPresenterMapperImplProvider.get());
  }

  public static AddPostViewModel_Factory create(Provider<AddPostUseCase> mAddPostUseCaseProvider,
      Provider<GetCountUseCase> getCountUseCaseProvider,
      Provider<PresenterMapperImpl> mPresenterMapperImplProvider) {
    return new AddPostViewModel_Factory(mAddPostUseCaseProvider, getCountUseCaseProvider, mPresenterMapperImplProvider);
  }

  public static AddPostViewModel newInstance(AddPostUseCase mAddPostUseCase,
      GetCountUseCase getCountUseCase, PresenterMapperImpl mPresenterMapperImpl) {
    return new AddPostViewModel(mAddPostUseCase, getCountUseCase, mPresenterMapperImpl);
  }
}
