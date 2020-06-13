package com.projects.android.postassessment.userInterface.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class PostDetailsFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private PostDetailsFragmentArgs() {
  }

  private PostDetailsFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static PostDetailsFragmentArgs fromBundle(@NonNull Bundle bundle) {
    PostDetailsFragmentArgs __result = new PostDetailsFragmentArgs();
    bundle.setClassLoader(PostDetailsFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("postId")) {
      int postId;
      postId = bundle.getInt("postId");
      __result.arguments.put("postId", postId);
    } else {
      throw new IllegalArgumentException("Required argument \"postId\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public int getPostId() {
    return (int) arguments.get("postId");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("postId")) {
      int postId = (int) arguments.get("postId");
      __result.putInt("postId", postId);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    PostDetailsFragmentArgs that = (PostDetailsFragmentArgs) object;
    if (arguments.containsKey("postId") != that.arguments.containsKey("postId")) {
      return false;
    }
    if (getPostId() != that.getPostId()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + getPostId();
    return result;
  }

  @Override
  public String toString() {
    return "PostDetailsFragmentArgs{"
        + "postId=" + getPostId()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(PostDetailsFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(int postId) {
      this.arguments.put("postId", postId);
    }

    @NonNull
    public PostDetailsFragmentArgs build() {
      PostDetailsFragmentArgs result = new PostDetailsFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setPostId(int postId) {
      this.arguments.put("postId", postId);
      return this;
    }

    @SuppressWarnings("unchecked")
    public int getPostId() {
      return (int) arguments.get("postId");
    }
  }
}
