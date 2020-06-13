package com.projects.android.postassessment;

import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
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
public final class PostApplication_MembersInjector implements MembersInjector<PostApplication> {
  private final Provider<DispatchingAndroidInjector<Object>> activityDispatchingAndroidInjectorProvider;

  public PostApplication_MembersInjector(
      Provider<DispatchingAndroidInjector<Object>> activityDispatchingAndroidInjectorProvider) {
    this.activityDispatchingAndroidInjectorProvider = activityDispatchingAndroidInjectorProvider;
  }

  public static MembersInjector<PostApplication> create(
      Provider<DispatchingAndroidInjector<Object>> activityDispatchingAndroidInjectorProvider) {
    return new PostApplication_MembersInjector(activityDispatchingAndroidInjectorProvider);}

  @Override
  public void injectMembers(PostApplication instance) {
    injectActivityDispatchingAndroidInjector(instance, activityDispatchingAndroidInjectorProvider.get());
  }

  public static void injectActivityDispatchingAndroidInjector(PostApplication instance,
      DispatchingAndroidInjector<Object> activityDispatchingAndroidInjector) {
    instance.activityDispatchingAndroidInjector = activityDispatchingAndroidInjector;
  }
}
