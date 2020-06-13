package com.projects.android.postassessment.userInterface.activities;

import com.projects.android.postassessment.userInterface.InjectingFragmentFactory;
import dagger.MembersInjector;
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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<InjectingFragmentFactory> injectingFragmentFactoryProvider;

  public MainActivity_MembersInjector(
      Provider<InjectingFragmentFactory> injectingFragmentFactoryProvider) {
    this.injectingFragmentFactoryProvider = injectingFragmentFactoryProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<InjectingFragmentFactory> injectingFragmentFactoryProvider) {
    return new MainActivity_MembersInjector(injectingFragmentFactoryProvider);}

  @Override
  public void injectMembers(MainActivity instance) {
    injectInjectingFragmentFactory(instance, injectingFragmentFactoryProvider.get());
  }

  public static void injectInjectingFragmentFactory(MainActivity instance,
      InjectingFragmentFactory injectingFragmentFactory) {
    instance.injectingFragmentFactory = injectingFragmentFactory;
  }
}
