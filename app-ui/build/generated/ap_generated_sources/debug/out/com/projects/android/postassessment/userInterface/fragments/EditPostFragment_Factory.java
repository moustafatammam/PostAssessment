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
public final class EditPostFragment_Factory implements Factory<EditPostFragment> {
  private final Provider<ViewModelFactory> mViewModelFactoryProvider;

  private final Provider<ViewMapperImpl> mViewMapperImplProvider;

  public EditPostFragment_Factory(Provider<ViewModelFactory> mViewModelFactoryProvider,
      Provider<ViewMapperImpl> mViewMapperImplProvider) {
    this.mViewModelFactoryProvider = mViewModelFactoryProvider;
    this.mViewMapperImplProvider = mViewMapperImplProvider;
  }

  @Override
  public EditPostFragment get() {
    return new EditPostFragment(mViewModelFactoryProvider.get(), mViewMapperImplProvider.get());
  }

  public static EditPostFragment_Factory create(
      Provider<ViewModelFactory> mViewModelFactoryProvider,
      Provider<ViewMapperImpl> mViewMapperImplProvider) {
    return new EditPostFragment_Factory(mViewModelFactoryProvider, mViewMapperImplProvider);
  }

  public static EditPostFragment newInstance(ViewModelFactory mViewModelFactory,
      ViewMapperImpl mViewMapperImpl) {
    return new EditPostFragment(mViewModelFactory, mViewMapperImpl);
  }
}
