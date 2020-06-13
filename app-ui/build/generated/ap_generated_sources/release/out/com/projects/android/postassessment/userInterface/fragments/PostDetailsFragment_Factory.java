package com.projects.android.postassessment.userInterface.fragments;

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
public final class PostDetailsFragment_Factory implements Factory<PostDetailsFragment> {
  private static final PostDetailsFragment_Factory INSTANCE = new PostDetailsFragment_Factory();

  @Override
  public PostDetailsFragment get() {
    return new PostDetailsFragment();
  }

  public static PostDetailsFragment_Factory create() {
    return INSTANCE;
  }

  public static PostDetailsFragment newInstance() {
    return new PostDetailsFragment();
  }
}
