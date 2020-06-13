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
public final class CreatePostFragment_Factory implements Factory<CreatePostFragment> {
  private static final CreatePostFragment_Factory INSTANCE = new CreatePostFragment_Factory();

  @Override
  public CreatePostFragment get() {
    return new CreatePostFragment();
  }

  public static CreatePostFragment_Factory create() {
    return INSTANCE;
  }

  public static CreatePostFragment newInstance() {
    return new CreatePostFragment();
  }
}
