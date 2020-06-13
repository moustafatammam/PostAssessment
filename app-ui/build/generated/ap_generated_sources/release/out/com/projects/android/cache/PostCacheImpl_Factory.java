package com.projects.android.cache;

import com.projects.android.cache.database.PostDatabase;
import com.projects.android.cache.mapper.CacheMapperImpl;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class PostCacheImpl_Factory implements Factory<PostCacheImpl> {
  private final Provider<PostDatabase> mPostDatabaseProvider;

  private final Provider<CacheMapperImpl> mCacheMapperImplProvider;

  public PostCacheImpl_Factory(Provider<PostDatabase> mPostDatabaseProvider,
      Provider<CacheMapperImpl> mCacheMapperImplProvider) {
    this.mPostDatabaseProvider = mPostDatabaseProvider;
    this.mCacheMapperImplProvider = mCacheMapperImplProvider;
  }

  @Override
  public PostCacheImpl get() {
    return new PostCacheImpl(mPostDatabaseProvider.get(), mCacheMapperImplProvider.get());
  }

  public static PostCacheImpl_Factory create(Provider<PostDatabase> mPostDatabaseProvider,
      Provider<CacheMapperImpl> mCacheMapperImplProvider) {
    return new PostCacheImpl_Factory(mPostDatabaseProvider, mCacheMapperImplProvider);
  }

  public static PostCacheImpl newInstance(PostDatabase mPostDatabase,
      CacheMapperImpl mCacheMapperImpl) {
    return new PostCacheImpl(mPostDatabase, mCacheMapperImpl);
  }
}
