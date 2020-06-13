package com.projects.android.data.dataSource;

import com.projects.android.data.repository.PostRemote;
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
public final class PostRemoteDataStore_Factory implements Factory<PostRemoteDataStore> {
  private final Provider<PostRemote> mPostRemoteProvider;

  public PostRemoteDataStore_Factory(Provider<PostRemote> mPostRemoteProvider) {
    this.mPostRemoteProvider = mPostRemoteProvider;
  }

  @Override
  public PostRemoteDataStore get() {
    return new PostRemoteDataStore(mPostRemoteProvider.get());
  }

  public static PostRemoteDataStore_Factory create(Provider<PostRemote> mPostRemoteProvider) {
    return new PostRemoteDataStore_Factory(mPostRemoteProvider);
  }

  public static PostRemoteDataStore newInstance(PostRemote mPostRemote) {
    return new PostRemoteDataStore(mPostRemote);
  }
}
