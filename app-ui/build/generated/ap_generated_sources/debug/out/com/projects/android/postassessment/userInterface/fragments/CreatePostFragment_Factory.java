package com.projects.android.postassessment.userInterface.fragments;

import com.projects.android.postassessment.mapper.ViewMapperImpl;
import com.projects.android.presentation.ViewModelFactory;
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
public final class CreatePostFragment_Factory implements Factory<CreatePostFragment> {
  private final Provider<ViewModelFactory> mViewModelFactoryProvider;

  private final Provider<ViewMapperImpl> mViewMapperImplProvider;

  public CreatePostFragment_Factory(Provider<ViewModelFactory> mViewModelFactoryProvider,
      Provider<ViewMapperImpl> mViewMapperImplProvider) {
    this.mViewModelFactoryProvider = mViewModelFactoryProvider;
    this.mViewMapperImplProvider = mViewMapperImplProvider;
  }

  @Override
  public CreatePostFragment get() {
    return new CreatePostFragment(mViewModelFactoryProvider.get(), mViewMapperImplProvider.get());
  }

  public static CreatePostFragment_Factory create(
      Provider<ViewModelFactory> mViewModelFactoryProvider,
      Provider<ViewMapperImpl> mViewMapperImplProvider) {
    return new CreatePostFragment_Factory(mViewModelFactoryProvider, mViewMapperImplProvider);
  }

  public static CreatePostFragment newInstance(ViewModelFactory mViewModelFactory,
      ViewMapperImpl mViewMapperImpl) {
    return new CreatePostFragment(mViewModelFactory, mViewMapperImpl);
  }
}
