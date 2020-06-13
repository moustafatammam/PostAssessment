package com.projects.android.data.repository;

import com.projects.android.data.model.DataPost;
import com.projects.android.domain.model.Post;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * an interface that defines how other dataSources behaves
 * it is implemented by the cacheSource and the remoteSource
 */
public interface PostDataStore {

    Completable savePost(DataPost dataPost);

    Completable saveAllPosts(List<DataPost> dataPosts);

    Completable deletePost(DataPost dataPost);

    Completable updatePost(DataPost dataPost);

    Observable<List<DataPost>> getAllPosts();

    Observable<DataPost> getPostById(int id);

    Single<Boolean> isCached(int id);

    Single<Boolean> isAllCached();

    Observable<Integer> getCount();
}
