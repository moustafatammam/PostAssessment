package com.projects.android.data.repository;

import com.projects.android.data.model.DataPost;
import java.util.List;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * an interface that defines how other layers communicates with it
 * it is implemented by the cache layer
 */
public interface PostCache {

    Completable savePost(DataPost dataPost);

    Completable saveAllPosts(List<DataPost> dataPosts);

    Completable deletePost(DataPost dataPost);

    Completable updatePost(DataPost dataPost);

    Observable<List<DataPost>> getAllPosts();

    Observable<DataPost> getPostById(int id);

    Single<Boolean> isAllCached();

    Single<Boolean> isCached(int id);

    Observable<Integer> getCount();
}
