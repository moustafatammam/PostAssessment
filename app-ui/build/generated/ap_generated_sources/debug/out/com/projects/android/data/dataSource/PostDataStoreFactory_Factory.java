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
public final class PostDataStoreFactory_Factory implements Factory<PostDataStoreFactory> {
  private final Provider<PostCache> mPostCacheProvider;

  private final Provider<PostCacheDataStore> mPostCacheDataStoreProvider;

  private final Provider<PostRemoteDataStore> mPostRemoteDataStoreProvider;

  public PostDataStoreFactory_Factory(Provider<PostCache> mPostCacheProvider,
      Provider<PostCacheDataStore> mPostCacheDataStoreProvider,
      Provider<PostRemoteDataStore> mPostRemoteDataStoreProvider) {
    this.mPostCacheProvider = mPostCacheProvider;
    this.mPostCacheDataStoreProvider = mPostCacheDataStoreProvider;
    this.mPostRemoteDataStoreProvider = mPostRemoteDataStoreProvider;
  }

  @Override
  public PostDataStoreFactory get() {
    return new PostDataStoreFactory(mPostCacheProvider.get(), mPostCacheDataStoreProvider.get(), mPostRemoteDataStoreProvider.get());
  }

  public static PostDataStoreFactory_Factory create(Provider<PostCache> mPostCacheProvider,
      Provider<PostCacheDataStore> mPostCacheDataStoreProvider,
      Provider<PostRemoteDataStore> mPostRemoteDataStoreProvider) {
    return new PostDataStoreFactory_Factory(mPostCacheProvider, mPostCacheDataStoreProvider, mPostRemoteDataStoreProvider);
  }

  public static PostDataStoreFactory newInstance(PostCache mPostCache,
      PostCacheDataStore mPostCacheDataStore, PostRemoteDataStore mPostRemoteDataStore) {
    return new PostDataStoreFactory(mPostCache, mPostCacheDataStore, mPostRemoteDataStore);
  }
}
