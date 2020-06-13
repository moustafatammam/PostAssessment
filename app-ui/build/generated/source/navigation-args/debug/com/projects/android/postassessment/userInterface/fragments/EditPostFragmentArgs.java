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

public class EditPostFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private EditPostFragmentArgs() {
  }

  private EditPostFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static EditPostFragmentArgs fromBundle(@NonNull Bundle bundle) {
    EditPostFragmentArgs __result = new EditPostFragmentArgs();
    bundle.setClassLoader(EditPostFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("updateId")) {
      int updateId;
      updateId = bundle.getInt("updateId");
      __result.arguments.put("updateId", updateId);
    } else {
      throw new IllegalArgumentException("Required argument \"updateId\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public int getUpdateId() {
    return (int) arguments.get("updateId");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("updateId")) {
      int updateId = (int) arguments.get("updateId");
      __result.putInt("updateId", updateId);
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
    EditPostFragmentArgs that = (EditPostFragmentArgs) object;
    if (arguments.containsKey("updateId") != that.arguments.containsKey("updateId")) {
      return false;
    }
    if (getUpdateId() != that.getUpdateId()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + getUpdateId();
    return result;
  }

  @Override
  public String toString() {
    return "EditPostFragmentArgs{"
        + "updateId=" + getUpdateId()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(EditPostFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(int updateId) {
      this.arguments.put("updateId", updateId);
    }

    @NonNull
    public EditPostFragmentArgs build() {
      EditPostFragmentArgs result = new EditPostFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setUpdateId(int updateId) {
      this.arguments.put("updateId", updateId);
      return this;
    }

    @SuppressWarnings("unchecked")
    public int getUpdateId() {
      return (int) arguments.get("updateId");
    }
  }
}
