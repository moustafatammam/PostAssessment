package com.projects.android.postassessment.userInterface.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.projects.android.postassessment.R;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class PostListFragmentDirections {
  private PostListFragmentDirections() {
  }

  @NonNull
  public static ActionPostListFragmentToPostDetailsFragment actionPostListFragmentToPostDetailsFragment(int postId) {
    return new ActionPostListFragmentToPostDetailsFragment(postId);
  }

  @NonNull
  public static ActionPostListFragmentToEditPostFragment actionPostListFragmentToEditPostFragment(int updateId) {
    return new ActionPostListFragmentToEditPostFragment(updateId);
  }

  @NonNull
  public static NavDirections actionPostListFragmentToCreatePostFragment() {
    return new ActionOnlyNavDirections(R.id.action_postListFragment_to_createPostFragment);
  }

  public static class ActionPostListFragmentToPostDetailsFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionPostListFragmentToPostDetailsFragment(int postId) {
      this.arguments.put("postId", postId);
    }

    @NonNull
    public ActionPostListFragmentToPostDetailsFragment setPostId(int postId) {
      this.arguments.put("postId", postId);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("postId")) {
        int postId = (int) arguments.get("postId");
        __result.putInt("postId", postId);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_postListFragment_to_postDetailsFragment;
    }

    @SuppressWarnings("unchecked")
    public int getPostId() {
      return (int) arguments.get("postId");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionPostListFragmentToPostDetailsFragment that = (ActionPostListFragmentToPostDetailsFragment) object;
      if (arguments.containsKey("postId") != that.arguments.containsKey("postId")) {
        return false;
      }
      if (getPostId() != that.getPostId()) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + getPostId();
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionPostListFragmentToPostDetailsFragment(actionId=" + getActionId() + "){"
          + "postId=" + getPostId()
          + "}";
    }
  }

  public static class ActionPostListFragmentToEditPostFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionPostListFragmentToEditPostFragment(int updateId) {
      this.arguments.put("updateId", updateId);
    }

    @NonNull
    public ActionPostListFragmentToEditPostFragment setUpdateId(int updateId) {
      this.arguments.put("updateId", updateId);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("updateId")) {
        int updateId = (int) arguments.get("updateId");
        __result.putInt("updateId", updateId);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_postListFragment_to_editPostFragment;
    }

    @SuppressWarnings("unchecked")
    public int getUpdateId() {
      return (int) arguments.get("updateId");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionPostListFragmentToEditPostFragment that = (ActionPostListFragmentToEditPostFragment) object;
      if (arguments.containsKey("updateId") != that.arguments.containsKey("updateId")) {
        return false;
      }
      if (getUpdateId() != that.getUpdateId()) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + getUpdateId();
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionPostListFragmentToEditPostFragment(actionId=" + getActionId() + "){"
          + "updateId=" + getUpdateId()
          + "}";
    }
  }
}
