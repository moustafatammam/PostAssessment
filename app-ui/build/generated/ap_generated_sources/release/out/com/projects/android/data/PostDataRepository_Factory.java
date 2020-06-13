package com.projects.android.data;

import com.projects.android.data.dataSource.PostDataStoreFactory;
import com.projects.android.data.mapper.DataMapperImpl;
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
public final class PostDataRepository_Factory implements Factory<PostDataRepository> {
  private final Provider<PostDataStoreFactory> mPostDataStoreFactoryProvider;

  private final Provider<DataMapperImpl> mDataMapperImplProvider;

  public PostDataRepository_Factory(Provider<PostDataStoreFactory> mPostDataStoreFactoryProvider,
      Provider<DataMapperImpl> mDataMapperImplProvider) {
    this.mPostDataStoreFactoryProvider = mPostDataStoreFactoryProvider;
    this.mDataMapperImplProvider = mDataMapperImplProvider;
  }

  @Override
  public PostDataRepository get() {
    return new PostDataRepository(mPostDataStoreFactoryProvider.get(), mDataMapperImplProvider.get());
  }

  public static PostDataRepository_Factory create(
      Provider<PostDataStoreFactory> mPostDataStoreFactoryProvider,
      Provider<DataMapperImpl> mDataMapperImplProvider) {
    return new PostDataRepository_Factory(mPostDataStoreFactoryProvider, mDataMapperImplProvider);
  }

  public static PostDataRepository newInstance(PostDataStoreFactory mPostDataStoreFactory,
      DataMapperImpl mDataMapperImpl) {
    return new PostDataRepository(mPostDataStoreFactory, mDataMapperImpl);
  }
}
