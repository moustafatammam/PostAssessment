package com.projects.android.postassessment.di.module;

import android.app.Application;
import com.projects.android.cache.database.PostDatabase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class CacheModule_ProvidePostApplicationFactory implements Factory<PostDatabase> {
  private final Provider<Application> applicationProvider;

  public CacheModule_ProvidePostApplicationFactory(Provider<Application> applicationProvider) {
    this.applicationProvider = applicationProvider;
  }

  @Override
  public PostDatabase get() {
    return providePostApplication(applicationProvider.get());
  }

  public static CacheModule_ProvidePostApplicationFactory create(
      Provider<Application> applicationProvider) {
    return new CacheModule_ProvidePostApplicationFactory(applicationProvider);
  }

  public static PostDatabase providePostApplication(Application application) {
    return Preconditions.checkNotNull(CacheModule.providePostApplication(application), "Cannot return null from a non-@Nullable @Provides method");
  }
}
