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
public final class PostDetailsFragment_Factory implements Factory<PostDetailsFragment> {
  private final Provider<ViewModelFactory> mViewModelFactoryProvider;

  private final Provider<ViewMapperImpl> mViewMapperImplProvider;

  public PostDetailsFragment_Factory(Provider<ViewModelFactory> mViewModelFactoryProvider,
      Provider<ViewMapperImpl> mViewMapperImplProvider) {
    this.mViewModelFactoryProvider = mViewModelFactoryProvider;
    this.mViewMapperImplProvider = mViewMapperImplProvider;
  }

  @Override
  public PostDetailsFragment get() {
    return new PostDetailsFragment(mViewModelFactoryProvider.get(), mViewMapperImplProvider.get());
  }

  public static PostDetailsFragment_Factory create(
      Provider<ViewModelFactory> mViewModelFactoryProvider,
      Provider<ViewMapperImpl> mViewMapperImplProvider) {
    return new PostDetailsFragment_Factory(mViewModelFactoryProvider, mViewMapperImplProvider);
  }

  public static PostDetailsFragment newInstance(ViewModelFactory mViewModelFactory,
      ViewMapperImpl mViewMapperImpl) {
    return new PostDetailsFragment(mViewModelFactory, mViewMapperImpl);
  }
}
