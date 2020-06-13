// Generated by data binding compiler. Do not edit!
package com.projects.android.postassessment.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.projects.android.postassessment.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentPostDetailsBinding extends ViewDataBinding {
  protected FragmentPostDetailsBinding(Object _bindingComponent, View _root, int _localFieldCount) {
    super(_bindingComponent, _root, _localFieldCount);
  }

  @NonNull
  public static FragmentPostDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_post_details, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentPostDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentPostDetailsBinding>inflateInternal(inflater, R.layout.fragment_post_details, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentPostDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_post_details, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentPostDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentPostDetailsBinding>inflateInternal(inflater, R.layout.fragment_post_details, null, false, component);
  }

  public static FragmentPostDetailsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentPostDetailsBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentPostDetailsBinding)bind(component, view, R.layout.fragment_post_details);
  }
}
