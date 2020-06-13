package com.projects.android.postassessment.userInterface.fragments;

import com.projects.android.postassessment.userInterface.adapter.PostListAdapter;
import dagger.MembersInjector;
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
public final class PostListFragment_MembersInjector implements MembersInjector<PostListFragment> {
  private final Provider<PostListAdapter> mPostListAdapterProvider;

  public PostListFragment_MembersInjector(Provider<PostListAdapter> mPostListAdapterProvider) {
    this.mPostListAdapterProvider = mPostListAdapterProvider;
  }

  public static MembersInjector<PostListFragment> create(
      Provider<PostListAdapter> mPostListAdapterProvider) {
    return new PostListFragment_MembersInjector(mPostListAdapterProvider);}

  @Override
  public void injectMembers(PostListFragment instance) {
    injectMPostListAdapter(instance, mPostListAdapterProvider.get());
  }

  public static void injectMPostListAdapter(PostListFragment instance,
      PostListAdapter mPostListAdapter) {
    instance.mPostListAdapter = mPostListAdapter;
  }
}
