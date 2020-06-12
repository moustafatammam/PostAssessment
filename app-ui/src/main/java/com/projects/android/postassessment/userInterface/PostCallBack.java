package com.projects.android.postassessment.userInterface;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.projects.android.postassessment.model.ViewPost;

public interface PostCallBack {

    void onPostClicked(ViewPost viewPost, View view);

    void onDeleteButtonClicked(ViewPost viewPost, View view, RecyclerView.ViewHolder viewHolder);

    void onEditButtonClicked(ViewPost viewPost, View view);
}
