package com.projects.android.presentation.mapper;

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
public final class PresenterMapperImpl_Factory implements Factory<PresenterMapperImpl> {
  private static final PresenterMapperImpl_Factory INSTANCE = new PresenterMapperImpl_Factory();

  @Override
  public PresenterMapperImpl get() {
    return new PresenterMapperImpl();
  }

  public static PresenterMapperImpl_Factory create() {
    return INSTANCE;
  }

  public static PresenterMapperImpl newInstance() {
    return new PresenterMapperImpl();
  }
}
