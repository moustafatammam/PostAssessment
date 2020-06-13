package com.projects.android.data.repository;

import com.projects.android.data.model.DataPost;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * an interface that defines how other layers communicates with it
 * it is implemented by the remote layer
 */
public interface PostRemote {

    Completable savePost(DataPost dataPost);

    Completable deletePost(DataPost dataPost);

    Completable updatePost(DataPost dataPost);

    Observable<List<DataPost>> getAllPosts();

    Observable<DataPost> getPostById(int id);
}
