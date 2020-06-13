package com.projects.android.remote;

import android.util.Log;

import com.projects.android.data.mapper.DataMapperImpl;
import com.projects.android.data.model.DataPost;
import com.projects.android.data.repository.PostRemote;
import com.projects.android.remote.mapper.RemoteMapperImpl;
import com.projects.android.remote.model.RemotePost;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;

public class PostRemoteImpl implements PostRemote {

    private PostService mPostService;
    private RemoteMapperImpl mRemoteMapperImpl;

    @Inject
    public PostRemoteImpl(PostService mPostService, RemoteMapperImpl mRemoteMapperImpl) {
        this.mPostService = mPostService;
        this.mRemoteMapperImpl = mRemoteMapperImpl;
    }

    @Override
    public Completable savePost(DataPost dataPost) {
         return Completable.defer(() -> {
            mPostService.savePost(mRemoteMapperImpl.mapToRemoteModel(dataPost));
            return Completable.complete();
        });
    }

    @Override
    public Completable deletePost(DataPost dataPost) {
        return Completable.defer(() -> {
            mPostService.deletePost(mRemoteMapperImpl.mapToRemoteModel(dataPost).getId());
            return Completable.complete();
        });
    }

    @Override
    public Completable updatePost(DataPost dataPost) {
        return Completable.defer(() -> {
            mPostService.updatePost(mRemoteMapperImpl.mapToRemoteModel(dataPost).getId(), mRemoteMapperImpl.mapToRemoteModel(dataPost));
            return Completable.complete();
        });
    }

    @Override
    public Observable<List<DataPost>> getAllPosts() {
        return mPostService.getAllPosts()
                .map(remotePosts -> {
                    List<DataPost> dataPostList = new ArrayList<>();
                    for (RemotePost remotePost : remotePosts){
                        dataPostList.add(mRemoteMapperImpl.mapFromRemoteModel(remotePost));
                    }
                    return dataPostList;
                });
    }

    @Override
    public Observable<DataPost> getPostById(int id) {
        return mPostService.getPostById(id)
                .map(remotePost -> mRemoteMapperImpl.mapFromRemoteModel(remotePost));

    }
}
