package com.projects.android.data.dataSource;

import com.projects.android.data.repository.PostCache;
import com.projects.android.data.repository.PostDataStore;

import javax.inject.Inject;

public class PostDataStoreFactory {

    private PostCache mPostCache;
    private PostCacheDataStore mPostCacheDataStore;
    private PostRemoteDataStore mPostRemoteDataStore;

    @Inject
    public PostDataStoreFactory(PostCache mPostCache, PostCacheDataStore mPostCacheDataStore, PostRemoteDataStore mPostRemoteDataStore) {
        this.mPostCache = mPostCache;
        this.mPostCacheDataStore = mPostCacheDataStore;
        this.mPostRemoteDataStore = mPostRemoteDataStore;
    }

    public PostDataStore retrieveDataStore(boolean isCached){
        if (isCached){
            return mPostCacheDataStore;
        }else{
            return mPostRemoteDataStore;
        }
    }

    public PostCacheDataStore getPostCacheDataStore() {
        return mPostCacheDataStore;
    }

    public PostRemoteDataStore getPostRemoteDataStore() {
        return mPostRemoteDataStore;
    }
}
