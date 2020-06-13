package com.projects.android.postassessment;

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
public final class UiThread_Factory implements Factory<UiThread> {
  private static final UiThread_Factory INSTANCE = new UiThread_Factory();

  @Override
  public UiThread get() {
    return new UiThread();
  }

  public static UiThread_Factory create() {
    return INSTANCE;
  }

  public static UiThread newInstance() {
    return new UiThread();
  }
}
