package com.projects.android.data.mapper;

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
public final class DataMapperImpl_Factory implements Factory<DataMapperImpl> {
  private static final DataMapperImpl_Factory INSTANCE = new DataMapperImpl_Factory();

  @Override
  public DataMapperImpl get() {
    return new DataMapperImpl();
  }

  public static DataMapperImpl_Factory create() {
    return INSTANCE;
  }

  public static DataMapperImpl newInstance() {
    return new DataMapperImpl();
  }
}
