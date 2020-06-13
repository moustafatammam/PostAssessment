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
public final class EditPostFragment_Factory implements Factory<EditPostFragment> {
  private static final EditPostFragment_Factory INSTANCE = new EditPostFragment_Factory();

  @Override
  public EditPostFragment get() {
    return new EditPostFragment();
  }

  public static EditPostFragment_Factory create() {
    return INSTANCE;
  }

  public static EditPostFragment newInstance() {
    return new EditPostFragment();
  }
}
