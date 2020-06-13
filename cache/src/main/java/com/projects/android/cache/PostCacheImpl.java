package com.projects.android.cache;

import com.projects.android.cache.database.PostDatabase;
import com.projects.android.cache.mapper.CacheMapperImpl;
import com.projects.android.cache.model.CachePost;
import com.projects.android.data.model.DataPost;
import com.projects.android.data.repository.PostCache;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * communicates with data layer it handles all the operations done from the data layer
 * and using room dao to cache it to the database
 */
public class PostCacheImpl implements PostCache {

    private PostDatabase mPostDatabase;
    private CacheMapperImpl mCacheMapperImpl;

    @Inject
    public PostCacheImpl(PostDatabase mPostDatabase, CacheMapperImpl mCacheMapperImpl) {
        this.mPostDatabase = mPostDatabase;
        this.mCacheMapperImpl = mCacheMapperImpl;
    }

    @Override
    public Completable savePost(DataPost dataPost) {
        return Completable.defer(() -> {
            mPostDatabase.postDao().savePost(mCacheMapperImpl.mapToCached(dataPost));
            return Completable.complete();
        });
    }

    @Override
    public Completable saveAllPosts(List<DataPost> dataPosts) {
        return Completable.defer(() -> {
            List<CachePost> cachePosts = dataPosts.stream().map(new Function<DataPost, CachePost>() {
                @Override
                public CachePost apply(DataPost dataPost) {
                    return mCacheMapperImpl.mapToCached(dataPost);
                }
            }).collect(Collectors.toList());
            mPostDatabase.postDao().saveAllPosts(cachePosts);
            return Completable.complete();
        });
    }

    @Override
    public Completable deletePost(DataPost dataPost) {
        return Completable.defer(() -> {
            mPostDatabase.postDao().deletePost(mCacheMapperImpl.mapToCached(dataPost).getId());
            return Completable.complete();
        });
    }

    @Override
    public Completable updatePost(DataPost dataPost) {
        return Completable.defer(() -> {
            CachePost cachePost = mCacheMapperImpl.mapToCached(dataPost);
            mPostDatabase.postDao().updatePost(cachePost.getTitle(), cachePost.getBody(), cachePost.getId());
            return Completable.complete();
        });
    }

    @Override
    public Observable<List<DataPost>> getAllPosts() {
        return Observable.just(mPostDatabase.postDao().getAllPost())
                .map(cachedPosts -> {
                    List<DataPost> dataPostList = new ArrayList<>();
                    for (CachePost cachePost : cachedPosts){
                        dataPostList.add(mCacheMapperImpl.mapFromCached(cachePost));
                    }
                    return dataPostList;
                });
    }

    @Override
    public Observable<DataPost> getPostById(int id) {
        return Observable.just(mPostDatabase.postDao().getPostById(id))
                .map(cachePost -> mCacheMapperImpl.mapFromCached(cachePost));
    }

    @Override
    public Single<Boolean> isAllCached() {
        return Single.defer(() -> Single.just(!mPostDatabase.postDao().getAllPost().isEmpty()));
    }

    @Override
    public Single<Boolean> isCached(int id) {
        return Single.defer(() -> Single.just(mPostDatabase.postDao().getPostById(id) != null));
    }

    @Override
    public Observable<Integer> getCount() {
        return Observable.defer(() -> Observable.just(mPostDatabase.postDao().getRowCount()));
    }


}
