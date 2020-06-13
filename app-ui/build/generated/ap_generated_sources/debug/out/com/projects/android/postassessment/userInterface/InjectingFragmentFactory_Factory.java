package com.projects.android.postassessment.userInterface;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import java.util.Map;
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
public final class InjectingFragmentFactory_Factory implements Factory<InjectingFragmentFactory> {
  private final Provider<Map<Class<? extends Fragment>, Provider<Fragment>>> fragmentMapProvider;

  public InjectingFragmentFactory_Factory(
      Provider<Map<Class<? extends Fragment>, Provider<Fragment>>> fragmentMapProvider) {
    this.fragmentMapProvider = fragmentMapProvider;
  }

  @Override
  public InjectingFragmentFactory get() {
    return new InjectingFragmentFactory(fragmentMapProvider.get());
  }

  public static InjectingFragmentFactory_Factory create(
      Provider<Map<Class<? extends Fragment>, Provider<Fragment>>> fragmentMapProvider) {
    return new InjectingFragmentFactory_Factory(fragmentMapProvider);
  }

  public static InjectingFragmentFactory newInstance(
      Map<Class<? extends Fragment>, Provider<Fragment>> fragmentMap) {
    return new InjectingFragmentFactory(fragmentMap);
  }
}
