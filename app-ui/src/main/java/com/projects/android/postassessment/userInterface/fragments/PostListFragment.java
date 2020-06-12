package com.projects.android.postassessment.userInterface.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.projects.android.cache.PostCacheImpl;
import com.projects.android.postassessment.R;
import com.projects.android.postassessment.databinding.FragmentPostListBinding;
import com.projects.android.postassessment.mapper.ViewMapperImpl;
import com.projects.android.postassessment.model.ViewPost;
import com.projects.android.postassessment.userInterface.PostCallBack;
import com.projects.android.postassessment.userInterface.PostListener;
import com.projects.android.postassessment.userInterface.activities.MainActivity;
import com.projects.android.postassessment.userInterface.adapter.PostListAdapter;
import com.projects.android.presentation.ViewModelFactory;
import com.projects.android.presentation.model.PresenterPost;
import com.projects.android.presentation.viewModel.DeletePostViewModel;
import com.projects.android.presentation.viewModel.GetAllPostsViewModel;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class PostListFragment extends Fragment implements PostCallBack{

    private RecyclerView mRecyclerView;



    PostListAdapter mPostListAdapter = new PostListAdapter(this);

    private FragmentPostListBinding fragmentPostListBinding;
    private FloatingActionButton mFloatingActionButton;

    private GetAllPostsViewModel mGetAllPostsViewModel;
    private DeletePostViewModel mDeletePostViewModel;
    private ViewModelFactory mViewModelFactory;
    private ViewMapperImpl mViewMapperImpl;

    @Inject
    public PostListFragment(ViewModelFactory mViewModelFactory, ViewMapperImpl mViewMapperImpl) {
        this.mViewModelFactory = mViewModelFactory;
        this.mViewMapperImpl = mViewMapperImpl;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentPostListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_post_list, container, false);
        return fragmentPostListBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        mGetAllPostsViewModel = new ViewModelProvider(this, mViewModelFactory).get(GetAllPostsViewModel.class);



        mDeletePostViewModel = new ViewModelProvider(this, mViewModelFactory).get(DeletePostViewModel.class);

        mFloatingActionButton = fragmentPostListBinding.addPostFab;
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Navigation.findNavController(view).navigate(R.id.action_postListFragment_to_createPostFragment);
                }catch (IllegalArgumentException e){
                    e.printStackTrace();
                    Log.d("a", e.getMessage());
                }

            }
        });


        mGetAllPostsViewModel.getPostListLiveData().observe(this, new Observer<List<PresenterPost>>() {
            @Override
            public void onChanged(List<PresenterPost> presenterPosts) {
                List<ViewPost> viewPostList = presenterPosts.stream().map(new Function<PresenterPost, ViewPost>() {
                    @Override
                    public ViewPost apply(PresenterPost presenterPost) {
                        return mViewMapperImpl.mapToViewUser(presenterPost);
                    }
                }).collect(Collectors.toList());
                mPostListAdapter.submitList(viewPostList);
                ((MainActivity) getActivity()).getSupportActionBar().setTitle("My Posts");
            }
        });
        setupRecyclerView();

    }

    private void setupRecyclerView() {
        mRecyclerView = fragmentPostListBinding.postListRecyclerView;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mPostListAdapter);
    }


    public void setupAlertDialog(ViewPost viewPost) {
        AlertDialog.Builder deleteAlert = new AlertDialog.Builder(getContext());
        deleteAlert.setTitle("Delete Post");
        deleteAlert.setMessage("You are about to delete this post. Are you sure you want to continue?");
        deleteAlert.setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mDeletePostViewModel.deletePost(mViewMapperImpl.mapFromViewPost(viewPost)).observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        mPostListAdapter.notifyDataSetChanged();
                        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });
        deleteAlert.show();
    }

    @Override
    public void onPostClicked(ViewPost viewPost, View view) {
        Navigation.findNavController(view).navigate(PostListFragmentDirections.actionPostListFragmentToPostDetailsFragment(viewPost.getId()));
    }

    @Override
    public void onDeleteButtonClicked(ViewPost viewPost, View view, RecyclerView.ViewHolder viewHolder) {
        setupAlertDialog(viewPost);

    }

    @Override
    public void onEditButtonClicked(ViewPost viewPost, View view) {
        Navigation.findNavController(view).navigate(PostListFragmentDirections.actionPostListFragmentToEditPostFragment(viewPost.getId()));

    }



  /*  public class PostItemListener implements PostCallBack {

        @Inject
        public PostItemListener() {
        }


        @Override
        public void onPostClicked(ViewPost viewPost, View view) {
            Navigation.findNavController(view).navigate(PostListFragmentDirections.actionPostListFragmentToPostDetailsFragment(viewPost.getId()));
        }

        @Override
        public void onDeleteButtonClicked(ViewPost viewPost, View view) {
        }

        @Override
        public void onEditButtonClicked(View view) {
            Navigation.findNavController(view).navigate(R.id.action_postListFragment_to_editPostFragment);

        }
    }

   */


}
