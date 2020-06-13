package com.projects.android.postassessment.userInterface.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.projects.android.postassessment.R;

public class EditPostFragmentDirections {
  private EditPostFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionEditPostFragmentToPostListFragment() {
    return new ActionOnlyNavDirections(R.id.action_editPostFragment_to_postListFragment);
  }
}
