package com.projects.android.cache.mapper;

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
public final class CacheMapperImpl_Factory implements Factory<CacheMapperImpl> {
  private static final CacheMapperImpl_Factory INSTANCE = new CacheMapperImpl_Factory();

  @Override
  public CacheMapperImpl get() {
    return new CacheMapperImpl();
  }

  public static CacheMapperImpl_Factory create() {
    return INSTANCE;
  }

  public static CacheMapperImpl newInstance() {
    return new CacheMapperImpl();
  }
}
