package com.projects.android.postassessment.userInterface.adapter;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class PostListAdapter_Factory implements Factory<PostListAdapter> {
  private static final PostListAdapter_Factory INSTANCE = new PostListAdapter_Factory();

  @Override
  public PostListAdapter get() {
    return new PostListAdapter();
  }

  public static PostListAdapter_Factory create() {
    return INSTANCE;
  }

  public static PostListAdapter newInstance() {
    return new PostListAdapter();
  }
}
