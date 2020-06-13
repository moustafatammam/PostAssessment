package com.projects.android.postassessment.userInterface.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.projects.android.postassessment.R;

public class CreatePostFragmentDirections {
  private CreatePostFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionCreatePostFragmentToPostListFragment() {
    return new ActionOnlyNavDirections(R.id.action_createPostFragment_to_postListFragment);
  }
}
