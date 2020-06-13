package com.projects.android.data.dataSource;

import com.projects.android.data.model.DataPost;
import com.projects.android.data.repository.PostCache;
import com.projects.android.data.repository.PostDataStore;
import com.projects.android.data.repository.PostRemote;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * an implementation to the PostDataStore interface that defines how to use the remote data
 */
public class PostRemoteDataStore implements PostDataStore {

    private PostRemote mPostRemote;

    @Inject
    public PostRemoteDataStore(PostRemote mPostRemote){

        this.mPostRemote = mPostRemote;
    }

    @Override
    public Completable savePost(DataPost dataPost) {
        return mPostRemote.savePost(dataPost);
    }

    @Override
    public Completable saveAllPosts(List<DataPost> dataPosts) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Completable deletePost(DataPost dataPost) {
        return mPostRemote.deletePost(dataPost);
    }

    @Override
    public Completable updatePost(DataPost dataPost) {
        return mPostRemote.updatePost(dataPost);
    }

    @Override
    public Observable<List<DataPost>> getAllPosts() {
        return mPostRemote.getAllPosts();
    }

    @Override
    public Observable<DataPost> getPostById(int id) {
        return mPostRemote.getPostById(id);
    }

    @Override
    public Single<Boolean> isCached(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Single<Boolean> isAllCached() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Observable<Integer> getCount() {
        throw new UnsupportedOperationException();
    }

}
