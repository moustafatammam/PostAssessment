package com.projects.android.data.dataSource;

import com.projects.android.data.model.DataPost;
import com.projects.android.data.repository.PostCache;
import com.projects.android.data.repository.PostDataStore;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public class PostCacheDataStore implements PostDataStore {

    private PostCache mPostCache;

    @Inject
    public PostCacheDataStore(PostCache mPostCache){

        this.mPostCache = mPostCache;
    }

    @Override
    public Completable savePost(DataPost dataPost) {
        return mPostCache.savePost(dataPost);
    }

    @Override
    public Completable saveAllPosts(List<DataPost> dataPosts) {
        return mPostCache.saveAllPosts(dataPosts);
    }

    @Override
    public Completable deletePost(DataPost dataPost) {
        return mPostCache.deletePost(dataPost);
    }

    @Override
    public Completable updatePost(DataPost dataPost) {
        return mPostCache.updatePost(dataPost);
    }

    @Override
    public Observable<List<DataPost>> getAllPosts() {
        return mPostCache.getAllPosts();
    }

    @Override
    public Observable<DataPost> getPostById(int id) {
        return mPostCache.getPostById(id);
    }

    @Override
    public Single<Boolean> isCached(int id) {
        return mPostCache.isCached(id);
    }

    @Override
    public Single<Boolean> isAllCached() {
        return mPostCache.isAllCached();
    }
}
