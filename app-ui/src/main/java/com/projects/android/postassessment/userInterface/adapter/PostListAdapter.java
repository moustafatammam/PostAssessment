package com.projects.android.postassessment.userInterface.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.projects.android.postassessment.R;
import com.projects.android.postassessment.databinding.PostItemBinding;
import com.projects.android.postassessment.model.ViewPost;
import com.projects.android.postassessment.userInterface.PostCallBack;

import java.util.ArrayList;
import java.util.List;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.PostListViewHolder>{

    private List<ViewPost> viewPostList = new ArrayList<>();
    private PostCallBack postClickedCallBack;
    private ViewBinderHelper mViewBinderHelper = new ViewBinderHelper();
     private SwipeRevealLayout swipeRevealLayout;


    public PostListAdapter(PostCallBack postClickedCallBack) {
        this.postClickedCallBack = postClickedCallBack;
    }

    @NonNull
    @Override
    public PostListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PostItemBinding postItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.post_item, parent, false);
        return new PostListViewHolder(postItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostListViewHolder holder, int position) {

        holder.postItemBinding.setViewpost(viewPostList.get(position));

        setupSwipeReveal(holder);

        holder.postItemBinding.constraintItemLayout.setOnClickListener(view -> postClickedCallBack.onPostClicked(viewPostList.get(position), view));
        holder.postItemBinding.editPostButton.setOnClickListener(view -> postClickedCallBack.onEditButtonClicked(viewPostList.get(position),view));
        holder.postItemBinding.deletePostButton.setOnClickListener(view -> {
            postClickedCallBack.onDeleteButtonClicked(holder.postItemBinding.getViewpost(), view, holder);
            viewPostList.remove(position);
        });


    }

    private void setupSwipeReveal(@NonNull PostListViewHolder holder){
        swipeRevealLayout = holder.postItemBinding.swipeReveal;
        swipeRevealLayout.close(true);
        mViewBinderHelper.bind(holder.postItemBinding.swipeReveal, Integer.toString(holder.postItemBinding.getViewpost().getId()));
        mViewBinderHelper.setOpenOnlyOne(true);
    }

    @Override
    public int getItemCount() {
        return viewPostList == null ? 0 : viewPostList.size();
    }


    public void submitList(List<ViewPost> viewPostList){
        this.viewPostList = viewPostList;
        notifyDataSetChanged();
    }

    public class PostListViewHolder extends RecyclerView.ViewHolder{

        PostItemBinding postItemBinding;

        public PostListViewHolder(@NonNull PostItemBinding postItemBinding) {
            super(postItemBinding.getRoot());
            this.postItemBinding = postItemBinding;
        }
    }

}
