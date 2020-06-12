package com.projects.android.postassessment.di.module;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

import com.projects.android.postassessment.di.FragmentKey;
import com.projects.android.postassessment.userInterface.InjectingFragmentFactory;
import com.projects.android.postassessment.userInterface.fragments.CreatePostFragment;
import com.projects.android.postassessment.userInterface.fragments.EditPostFragment;
import com.projects.android.postassessment.userInterface.fragments.PostDetailsFragment;
import com.projects.android.postassessment.userInterface.fragments.PostListFragment;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class FragmentModule {

    @Binds
    @IntoMap
    @FragmentKey(PostListFragment.class)
    abstract Fragment bindPostListFragment(PostListFragment postListFragment);

    @Binds
    @IntoMap
    @FragmentKey(PostDetailsFragment.class)
    abstract Fragment bindPostDetailsFragment(PostDetailsFragment postDetailsFragment);

    @Binds
    @IntoMap
    @FragmentKey(EditPostFragment.class)
    abstract Fragment bindEditPostFragment(EditPostFragment editPostFragment);

    @Binds
    @IntoMap
    @FragmentKey(CreatePostFragment.class)
    abstract Fragment bindcreatePostFragment(CreatePostFragment createPostFragment);

    @Binds
    abstract FragmentFactory bindFragmentFactory(InjectingFragmentFactory injectingFragmentFactory);
}
