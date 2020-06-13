package com.projects.android.postassessment.userInterface.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import com.projects.android.postassessment.R;
import com.projects.android.postassessment.databinding.FragmentPostListBinding;
import com.projects.android.postassessment.mapper.ViewMapperImpl;
import com.projects.android.postassessment.model.ViewPost;
import com.projects.android.postassessment.userInterface.PostCallBack;
import com.projects.android.postassessment.userInterface.adapter.PostListAdapter;
import com.projects.android.presentation.ViewModelFactory;
import com.projects.android.presentation.model.PresenterPost;
import com.projects.android.presentation.viewModel.DeletePostViewModel;
import com.projects.android.presentation.viewModel.GetAllPostsViewModel;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.inject.Inject;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class PostListFragment extends Fragment implements PostCallBack {

    private RecyclerView mRecyclerView;
    private PostListAdapter mPostListAdapter;
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
        mFloatingActionButton.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_postListFragment_to_createPostFragment));

        setupRecyclerView();

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
            }
        });
    }

    private void setupRecyclerView() {
        mPostListAdapter = new PostListAdapter(this);
        mRecyclerView = fragmentPostListBinding.postListRecyclerView;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mPostListAdapter);
    }


    private void setupAlertDialog(ViewPost viewPost) {
        AlertDialog.Builder deleteAlert = new AlertDialog.Builder(getContext());
        deleteAlert.setTitle("Delete Post");
        deleteAlert.setMessage("You are about to delete this post. Are you sure you want to continue?");
        deleteAlert.setPositiveButton("DELETE", (dialogInterface, i) -> {
            if (isInternetAvailable(getContext())) { //returns true if internet available
                mDeletePostViewModel.deletePost(mViewMapperImpl.mapFromViewPost(viewPost)).observe(getViewLifecycleOwner(), s -> {
                    mPostListAdapter.notifyDataSetChanged();
                    Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
                });
            } else {
                Toast.makeText(getContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("cancel", (dialog, which) -> dialog.dismiss());
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

    private static boolean isInternetAvailable(Context context) {
        NetworkInfo info = (NetworkInfo) ((ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();

        if (info == null) {
            Log.d(TAG, "no internet connection");
            return false;
        } else {
            if (info.isConnected()) {
                Log.d(TAG, " internet connection available...");
                return true;
            } else {
                Log.d(TAG, " internet connection");
                return true;
            }

        }
    }

}
