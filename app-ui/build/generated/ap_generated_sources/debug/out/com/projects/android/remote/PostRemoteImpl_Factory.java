package com.projects.android.remote;

import com.projects.android.remote.mapper.RemoteMapperImpl;
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
public final class PostRemoteImpl_Factory implements Factory<PostRemoteImpl> {
  private final Provider<PostService> mPostServiceProvider;

  private final Provider<RemoteMapperImpl> mRemoteMapperImplProvider;

  public PostRemoteImpl_Factory(Provider<PostService> mPostServiceProvider,
      Provider<RemoteMapperImpl> mRemoteMapperImplProvider) {
    this.mPostServiceProvider = mPostServiceProvider;
    this.mRemoteMapperImplProvider = mRemoteMapperImplProvider;
  }

  @Override
  public PostRemoteImpl get() {
    return new PostRemoteImpl(mPostServiceProvider.get(), mRemoteMapperImplProvider.get());
  }

  public static PostRemoteImpl_Factory create(Provider<PostService> mPostServiceProvider,
      Provider<RemoteMapperImpl> mRemoteMapperImplProvider) {
    return new PostRemoteImpl_Factory(mPostServiceProvider, mRemoteMapperImplProvider);
  }

  public static PostRemoteImpl newInstance(PostService mPostService,
      RemoteMapperImpl mRemoteMapperImpl) {
    return new PostRemoteImpl(mPostService, mRemoteMapperImpl);
  }
}
