package com.projects.android.cache.mapper;

import com.projects.android.cache.model.CachePost;
import com.projects.android.data.model.DataPost;

import javax.inject.Inject;

public class CacheMapperImpl implements CacheMapper<CachePost, DataPost> {


    @Inject
    public CacheMapperImpl() {
    }

    @Override
    public DataPost mapFromCached(CachePost cachePost) {
        return new DataPost(cachePost.getId(), cachePost.getTitle(), cachePost.getBody());
    }

    @Override
    public CachePost mapToCached(DataPost dataPost) {
        return new CachePost(dataPost.getId(), dataPost.getTitle(), dataPost.getBody());
    }
}
