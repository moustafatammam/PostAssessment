package com.projects.android.postassessment.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.projects.android.postassessment.di.ViewModelKey;
import com.projects.android.presentation.ViewModelFactory;
import com.projects.android.presentation.viewModel.AddPostViewModel;
import com.projects.android.presentation.viewModel.DeletePostViewModel;
import com.projects.android.presentation.viewModel.GetAllPostsViewModel;
import com.projects.android.presentation.viewModel.GetPostByIdViewModel;
import com.projects.android.presentation.viewModel.UpdatePostViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class PreseneterModule {

    @Binds
    @IntoMap
    @ViewModelKey(GetAllPostsViewModel.class)
    public abstract ViewModel bindGetAllPostsViewModel(GetAllPostsViewModel getAllPostsViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(GetPostByIdViewModel.class)
    public abstract ViewModel bindGetPostByIdViewModel(GetPostByIdViewModel getPostByIdViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(AddPostViewModel.class)
    public abstract ViewModel bindAddPostViewModel(AddPostViewModel addPostViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DeletePostViewModel.class)
    public abstract ViewModel bindDeletePostViewModel(DeletePostViewModel deletePostViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(UpdatePostViewModel.class)
    public abstract ViewModel bindUpdatePostViewModel(UpdatePostViewModel updatePostViewModel);

    @Binds
    abstract ViewModelProvider.Factory  bindViewModelFactory(ViewModelFactory viewModelFactory);
}
