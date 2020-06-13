package com.projects.android.remote.mapper;

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
public final class RemoteMapperImpl_Factory implements Factory<RemoteMapperImpl> {
  private static final RemoteMapperImpl_Factory INSTANCE = new RemoteMapperImpl_Factory();

  @Override
  public RemoteMapperImpl get() {
    return new RemoteMapperImpl();
  }

  public static RemoteMapperImpl_Factory create() {
    return INSTANCE;
  }

  public static RemoteMapperImpl newInstance() {
    return new RemoteMapperImpl();
  }
}
