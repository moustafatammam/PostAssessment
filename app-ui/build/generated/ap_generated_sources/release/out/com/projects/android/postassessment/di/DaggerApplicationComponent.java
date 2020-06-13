package com.projects.android.postassessment.di;

import android.app.Application;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.projects.android.cache.PostCacheImpl;
import com.projects.android.cache.PostCacheImpl_Factory;
import com.projects.android.cache.database.PostDatabase;
import com.projects.android.cache.mapper.CacheMapperImpl_Factory;
import com.projects.android.data.PostDataRepository;
import com.projects.android.data.PostDataRepository_Factory;
import com.projects.android.data.dataSource.PostCacheDataStore;
import com.projects.android.data.dataSource.PostCacheDataStore_Factory;
import com.projects.android.data.dataSource.PostDataStoreFactory;
import com.projects.android.data.dataSource.PostDataStoreFactory_Factory;
import com.projects.android.data.dataSource.PostRemoteDataStore;
import com.projects.android.data.dataSource.PostRemoteDataStore_Factory;
import com.projects.android.data.executor.JobExecutor_Factory;
import com.projects.android.data.mapper.DataMapperImpl_Factory;
import com.projects.android.domain.useCases.impl.AddPostUseCase;
import com.projects.android.domain.useCases.impl.AddPostUseCase_Factory;
import com.projects.android.domain.useCases.impl.DeletePostUseCase;
import com.projects.android.domain.useCases.impl.DeletePostUseCase_Factory;
import com.projects.android.domain.useCases.impl.GetAllPostsUseCase;
import com.projects.android.domain.useCases.impl.GetAllPostsUseCase_Factory;
import com.projects.android.domain.useCases.impl.GetPostByIdUseCase;
import com.projects.android.domain.useCases.impl.GetPostByIdUseCase_Factory;
import com.projects.android.domain.useCases.impl.UpdatePostUseCase;
import com.projects.android.domain.useCases.impl.UpdatePostUseCase_Factory;
import com.projects.android.postassessment.PostApplication;
import com.projects.android.postassessment.PostApplication_MembersInjector;
import com.projects.android.postassessment.UiThread_Factory;
import com.projects.android.postassessment.di.module.AppUiModule_ContributeMainActivity;
import com.projects.android.postassessment.di.module.CacheModule_ProvidePostApplicationFactory;
import com.projects.android.postassessment.di.module.RemoteModule_ProvidePostServiceFactory;
import com.projects.android.postassessment.mapper.ViewMapperImpl_Factory;
import com.projects.android.postassessment.userInterface.InjectingFragmentFactory;
import com.projects.android.postassessment.userInterface.activities.MainActivity;
import com.projects.android.postassessment.userInterface.activities.MainActivity_MembersInjector;
import com.projects.android.postassessment.userInterface.adapter.PostListAdapter_Factory;
import com.projects.android.postassessment.userInterface.fragments.CreatePostFragment;
import com.projects.android.postassessment.userInterface.fragments.CreatePostFragment_Factory;
import com.projects.android.postassessment.userInterface.fragments.EditPostFragment;
import com.projects.android.postassessment.userInterface.fragments.EditPostFragment_Factory;
import com.projects.android.postassessment.userInterface.fragments.PostDetailsFragment;
import com.projects.android.postassessment.userInterface.fragments.PostDetailsFragment_Factory;
import com.projects.android.postassessment.userInterface.fragments.PostListFragment;
import com.projects.android.postassessment.userInterface.fragments.PostListFragment_Factory;
import com.projects.android.presentation.ViewModelFactory;
import com.projects.android.presentation.ViewModelFactory_Factory;
import com.projects.android.presentation.mapper.PresenterMapperImpl_Factory;
import com.projects.android.presentation.viewModel.AddPostViewModel;
import com.projects.android.presentation.viewModel.AddPostViewModel_Factory;
import com.projects.android.presentation.viewModel.DeletePostViewModel;
import com.projects.android.presentation.viewModel.DeletePostViewModel_Factory;
import com.projects.android.presentation.viewModel.GetAllPostsViewModel;
import com.projects.android.presentation.viewModel.GetAllPostsViewModel_Factory;
import com.projects.android.presentation.viewModel.GetPostByIdViewModel;
import com.projects.android.presentation.viewModel.GetPostByIdViewModel_Factory;
import com.projects.android.presentation.viewModel.UpdatePostViewModel;
import com.projects.android.presentation.viewModel.UpdatePostViewModel_Factory;
import com.projects.android.remote.PostRemoteImpl;
import com.projects.android.remote.PostRemoteImpl_Factory;
import com.projects.android.remote.mapper.RemoteMapperImpl_Factory;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.DispatchingAndroidInjector_Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.MapBuilder;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import java.util.Collections;
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
public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<AppUiModule_ContributeMainActivity.MainActivitySubcomponent.Factory> mainActivitySubcomponentFactoryProvider;

  private Provider<Application> applicationProvider;

  private Provider<PostDatabase> providePostApplicationProvider;

  private Provider<PostCacheImpl> postCacheImplProvider;

  private Provider<PostCacheDataStore> postCacheDataStoreProvider;

  private Provider<PostRemoteImpl> postRemoteImplProvider;

  private Provider<PostRemoteDataStore> postRemoteDataStoreProvider;

  private Provider<PostDataStoreFactory> postDataStoreFactoryProvider;

  private Provider<PostDataRepository> postDataRepositoryProvider;

  private DaggerApplicationComponent(Application applicationParam) {

    initialize(applicationParam);
  }

  public static ApplicationComponent.Builder builder() {
    return new Builder();
  }

  private Map<Class<?>, Provider<AndroidInjector.Factory<?>>> getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(
      ) {
    return Collections.<Class<?>, Provider<AndroidInjector.Factory<?>>>singletonMap(MainActivity.class, (Provider) mainActivitySubcomponentFactoryProvider);}

  private DispatchingAndroidInjector<Object> getDispatchingAndroidInjectorOfObject() {
    return DispatchingAndroidInjector_Factory.newInstance(getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());}

  @SuppressWarnings("unchecked")
  private void initialize(final Application applicationParam) {
    this.mainActivitySubcomponentFactoryProvider = new Provider<AppUiModule_ContributeMainActivity.MainActivitySubcomponent.Factory>() {
      @Override
      public AppUiModule_ContributeMainActivity.MainActivitySubcomponent.Factory get() {
        return new MainActivitySubcomponentFactory();}
    };
    this.applicationProvider = InstanceFactory.create(applicationParam);
    this.providePostApplicationProvider = CacheModule_ProvidePostApplicationFactory.create(applicationProvider);
    this.postCacheImplProvider = PostCacheImpl_Factory.create(providePostApplicationProvider, CacheMapperImpl_Factory.create());
    this.postCacheDataStoreProvider = PostCacheDataStore_Factory.create((Provider) postCacheImplProvider);
    this.postRemoteImplProvider = PostRemoteImpl_Factory.create(RemoteModule_ProvidePostServiceFactory.create(), RemoteMapperImpl_Factory.create());
    this.postRemoteDataStoreProvider = PostRemoteDataStore_Factory.create((Provider) postRemoteImplProvider);
    this.postDataStoreFactoryProvider = PostDataStoreFactory_Factory.create((Provider) postCacheImplProvider, postCacheDataStoreProvider, postRemoteDataStoreProvider);
    this.postDataRepositoryProvider = PostDataRepository_Factory.create(postDataStoreFactoryProvider, DataMapperImpl_Factory.create());
  }

  @Override
  public void inject(PostApplication app) {
    injectPostApplication(app);}

  private PostApplication injectPostApplication(PostApplication instance) {
    PostApplication_MembersInjector.injectActivityDispatchingAndroidInjector(instance, getDispatchingAndroidInjectorOfObject());
    return instance;
  }

  private static final class Builder implements ApplicationComponent.Builder {
    private Application application;

    @Override
    public Builder application(Application application) {
      this.application = Preconditions.checkNotNull(application);
      return this;
    }

    @Override
    public ApplicationComponent build() {
      Preconditions.checkBuilderRequirement(application, Application.class);
      return new DaggerApplicationComponent(application);
    }
  }

  private final class MainActivitySubcomponentFactory implements AppUiModule_ContributeMainActivity.MainActivitySubcomponent.Factory {
    @Override
    public AppUiModule_ContributeMainActivity.MainActivitySubcomponent create(MainActivity arg0) {
      Preconditions.checkNotNull(arg0);
      return new MainActivitySubcomponentImpl(arg0);
    }
  }

  private final class MainActivitySubcomponentImpl implements AppUiModule_ContributeMainActivity.MainActivitySubcomponent {
    private Provider<GetAllPostsUseCase> getAllPostsUseCaseProvider;

    private Provider<GetAllPostsViewModel> getAllPostsViewModelProvider;

    private Provider<GetPostByIdUseCase> getPostByIdUseCaseProvider;

    private Provider<GetPostByIdViewModel> getPostByIdViewModelProvider;

    private Provider<AddPostUseCase> addPostUseCaseProvider;

    private Provider<AddPostViewModel> addPostViewModelProvider;

    private Provider<DeletePostUseCase> deletePostUseCaseProvider;

    private Provider<DeletePostViewModel> deletePostViewModelProvider;

    private Provider<UpdatePostUseCase> updatePostUseCaseProvider;

    private Provider<UpdatePostViewModel> updatePostViewModelProvider;

    private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> mapOfClassOfAndProviderOfViewModelProvider;

    private Provider<ViewModelFactory> viewModelFactoryProvider;

    private Provider<PostListFragment> postListFragmentProvider;

    private MainActivitySubcomponentImpl(MainActivity arg0) {

      initialize(arg0);
    }

    private Map<Class<? extends Fragment>, Provider<Fragment>> getMapOfClassOfAndProviderOfFragment(
        ) {
      return MapBuilder.<Class<? extends Fragment>, Provider<Fragment>>newMapBuilder(4).put(PostListFragment.class, (Provider) postListFragmentProvider).put(PostDetailsFragment.class, (Provider) PostDetailsFragment_Factory.create()).put(EditPostFragment.class, (Provider) EditPostFragment_Factory.create()).put(CreatePostFragment.class, (Provider) CreatePostFragment_Factory.create()).build();}

    private InjectingFragmentFactory getInjectingFragmentFactory() {
      return new InjectingFragmentFactory(getMapOfClassOfAndProviderOfFragment());}

    @SuppressWarnings("unchecked")
    private void initialize(final MainActivity arg0) {
      this.getAllPostsUseCaseProvider = GetAllPostsUseCase_Factory.create((Provider) DaggerApplicationComponent.this.postDataRepositoryProvider, (Provider) JobExecutor_Factory.create(), (Provider) UiThread_Factory.create());
      this.getAllPostsViewModelProvider = GetAllPostsViewModel_Factory.create(getAllPostsUseCaseProvider, PresenterMapperImpl_Factory.create());
      this.getPostByIdUseCaseProvider = GetPostByIdUseCase_Factory.create((Provider) DaggerApplicationComponent.this.postDataRepositoryProvider, (Provider) JobExecutor_Factory.create(), (Provider) UiThread_Factory.create());
      this.getPostByIdViewModelProvider = GetPostByIdViewModel_Factory.create(getPostByIdUseCaseProvider, PresenterMapperImpl_Factory.create());
      this.addPostUseCaseProvider = AddPostUseCase_Factory.create((Provider) DaggerApplicationComponent.this.postDataRepositoryProvider, (Provider) JobExecutor_Factory.create(), (Provider) UiThread_Factory.create());
      this.addPostViewModelProvider = AddPostViewModel_Factory.create(addPostUseCaseProvider, PresenterMapperImpl_Factory.create());
      this.deletePostUseCaseProvider = DeletePostUseCase_Factory.create((Provider) DaggerApplicationComponent.this.postDataRepositoryProvider, (Provider) JobExecutor_Factory.create(), (Provider) UiThread_Factory.create());
      this.deletePostViewModelProvider = DeletePostViewModel_Factory.create(deletePostUseCaseProvider, PresenterMapperImpl_Factory.create());
      this.updatePostUseCaseProvider = UpdatePostUseCase_Factory.create((Provider) DaggerApplicationComponent.this.postDataRepositoryProvider, (Provider) JobExecutor_Factory.create(), (Provider) UiThread_Factory.create());
      this.updatePostViewModelProvider = UpdatePostViewModel_Factory.create(updatePostUseCaseProvider, PresenterMapperImpl_Factory.create());
      this.mapOfClassOfAndProviderOfViewModelProvider = MapProviderFactory.<Class<? extends ViewModel>, ViewModel>builder(5).put(GetAllPostsViewModel.class, (Provider) getAllPostsViewModelProvider).put(GetPostByIdViewModel.class, (Provider) getPostByIdViewModelProvider).put(AddPostViewModel.class, (Provider) addPostViewModelProvider).put(DeletePostViewModel.class, (Provider) deletePostViewModelProvider).put(UpdatePostViewModel.class, (Provider) updatePostViewModelProvider).build();
      this.viewModelFactoryProvider = ViewModelFactory_Factory.create(mapOfClassOfAndProviderOfViewModelProvider);
      this.postListFragmentProvider = PostListFragment_Factory.create(viewModelFactoryProvider, ViewMapperImpl_Factory.create(), PostListAdapter_Factory.create());
    }

    @Override
    public void inject(MainActivity arg0) {
      injectMainActivity(arg0);}

    private MainActivity injectMainActivity(MainActivity instance) {
      MainActivity_MembersInjector.injectInjectingFragmentFactory(instance, getInjectingFragmentFactory());
      return instance;
    }
  }
}
