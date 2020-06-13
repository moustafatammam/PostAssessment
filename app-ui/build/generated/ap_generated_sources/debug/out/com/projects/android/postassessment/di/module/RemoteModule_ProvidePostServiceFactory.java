package com.projects.android.postassessment.di.module;

import com.projects.android.remote.PostService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RemoteModule_ProvidePostServiceFactory implements Factory<PostService> {
  private static final RemoteModule_ProvidePostServiceFactory INSTANCE = new RemoteModule_ProvidePostServiceFactory();

  @Override
  public PostService get() {
    return providePostService();
  }

  public static RemoteModule_ProvidePostServiceFactory create() {
    return INSTANCE;
  }

  public static PostService providePostService() {
    return Preconditions.checkNotNull(RemoteModule.providePostService(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
