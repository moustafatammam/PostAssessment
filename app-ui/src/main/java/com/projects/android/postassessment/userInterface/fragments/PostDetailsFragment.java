package com.projects.android.postassessment.userInterface.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.projects.android.postassessment.R;
import com.projects.android.postassessment.databinding.FragmentPostDetailsBinding;
import com.projects.android.postassessment.mapper.ViewMapperImpl;
import com.projects.android.presentation.ViewModelFactory;
import com.projects.android.presentation.model.PresenterPost;
import com.projects.android.presentation.viewModel.GetPostByIdViewModel;

import java.util.Objects;

import javax.inject.Inject;

public class PostDetailsFragment extends Fragment {

    private FragmentPostDetailsBinding fragmentPostDetailsBinding;
    private GetPostByIdViewModel mGetPostByIdViewModel;
    private ViewModelFactory mViewModelFactory;
    private ViewMapperImpl mViewMapperImpl;
     private int postId;

    @Inject
    public PostDetailsFragment(ViewModelFactory mViewModelFactory, ViewMapperImpl mViewMapperImpl){
        this.mViewModelFactory = mViewModelFactory;
        this.mViewMapperImpl = mViewMapperImpl;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentPostDetailsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_post_details, container, false);
        return fragmentPostDetailsBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        postId = PostDetailsFragmentArgs.fromBundle(Objects.requireNonNull(getArguments())).getPostId();
        mGetPostByIdViewModel = new ViewModelProvider(this, mViewModelFactory).get(GetPostByIdViewModel.class);

        mGetPostByIdViewModel.getPostByIdLiveData(postId).observe(this, new Observer<PresenterPost>() {
            @Override
            public void onChanged(PresenterPost presenterPost) {
                fragmentPostDetailsBinding.title.setText(mViewMapperImpl.mapToViewUser(presenterPost).getTitle());
                fragmentPostDetailsBinding.body.setText(mViewMapperImpl.mapToViewUser(presenterPost).getBody());
                fragmentPostDetailsBinding.body.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        fragmentPostDetailsBinding.body.toggle();
                    }
                });
            }
        });
    }
}
