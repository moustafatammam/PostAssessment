package com.projects.android.data.dataSource;

import com.projects.android.data.repository.PostCache;
import com.projects.android.data.repository.PostDataStore;

import javax.inject.Inject;

/**
 * a single source of truth that decides which source will be used
 */
public class PostDataStoreFactory {

    private PostCacheDataStore mPostCacheDataStore;
    private PostRemoteDataStore mPostRemoteDataStore;

    @Inject
    public PostDataStoreFactory(PostCacheDataStore mPostCacheDataStore, PostRemoteDataStore mPostRemoteDataStore) {
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
