package com.projects.android.data.dataSource;

import com.projects.android.data.repository.PostCache;
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
public final class PostCacheDataStore_Factory implements Factory<PostCacheDataStore> {
  private final Provider<PostCache> mPostCacheProvider;

  public PostCacheDataStore_Factory(Provider<PostCache> mPostCacheProvider) {
    this.mPostCacheProvider = mPostCacheProvider;
  }

  @Override
  public PostCacheDataStore get() {
    return new PostCacheDataStore(mPostCacheProvider.get());
  }

  public static PostCacheDataStore_Factory create(Provider<PostCache> mPostCacheProvider) {
    return new PostCacheDataStore_Factory(mPostCacheProvider);
  }

  public static PostCacheDataStore newInstance(PostCache mPostCache) {
    return new PostCacheDataStore(mPostCache);
  }
}
