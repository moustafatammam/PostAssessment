package com.projects.android.postassessment.userInterface.fragments;

import com.projects.android.postassessment.mapper.ViewMapperImpl;
import com.projects.android.postassessment.userInterface.adapter.PostListAdapter;
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
public final class PostListFragment_Factory implements Factory<PostListFragment> {
  private final Provider<ViewModelFactory> mViewModelFactoryProvider;

  private final Provider<ViewMapperImpl> mViewMapperImplProvider;

  private final Provider<PostListAdapter> mPostListAdapterProvider;

  public PostListFragment_Factory(Provider<ViewModelFactory> mViewModelFactoryProvider,
      Provider<ViewMapperImpl> mViewMapperImplProvider,
      Provider<PostListAdapter> mPostListAdapterProvider) {
    this.mViewModelFactoryProvider = mViewModelFactoryProvider;
    this.mViewMapperImplProvider = mViewMapperImplProvider;
    this.mPostListAdapterProvider = mPostListAdapterProvider;
  }

  @Override
  public PostListFragment get() {
    PostListFragment instance = new PostListFragment(mViewModelFactoryProvider.get(), mViewMapperImplProvider.get());
    PostListFragment_MembersInjector.injectMPostListAdapter(instance, mPostListAdapterProvider.get());
    return instance;
  }

  public static PostListFragment_Factory create(
      Provider<ViewModelFactory> mViewModelFactoryProvider,
      Provider<ViewMapperImpl> mViewMapperImplProvider,
      Provider<PostListAdapter> mPostListAdapterProvider) {
    return new PostListFragment_Factory(mViewModelFactoryProvider, mViewMapperImplProvider, mPostListAdapterProvider);
  }

  public static PostListFragment newInstance(ViewModelFactory mViewModelFactory,
      ViewMapperImpl mViewMapperImpl) {
    return new PostListFragment(mViewModelFactory, mViewMapperImpl);
  }
}
