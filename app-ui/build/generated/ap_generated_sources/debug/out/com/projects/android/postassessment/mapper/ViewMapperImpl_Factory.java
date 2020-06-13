package com.projects.android.postassessment.mapper;

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
public final class ViewMapperImpl_Factory implements Factory<ViewMapperImpl> {
  private static final ViewMapperImpl_Factory INSTANCE = new ViewMapperImpl_Factory();

  @Override
  public ViewMapperImpl get() {
    return new ViewMapperImpl();
  }

  public static ViewMapperImpl_Factory create() {
    return INSTANCE;
  }

  public static ViewMapperImpl newInstance() {
    return new ViewMapperImpl();
  }
}
