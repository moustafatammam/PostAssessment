package com.projects.android.data;

import com.projects.android.data.dataSource.PostDataStoreFactory;
import com.projects.android.data.mapper.DataMapperImpl;
import com.projects.android.data.model.DataPost;
import com.projects.android.domain.model.Post;
import com.projects.android.domain.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;

public class PostDataRepository implements PostRepository {

    private PostDataStoreFactory mPostDataStoreFactory;
    private DataMapperImpl mDataMapperImpl;

    @Inject
    public PostDataRepository(PostDataStoreFactory mPostDataStoreFactory, DataMapperImpl mDataMapperImpl) {
        this.mPostDataStoreFactory = mPostDataStoreFactory;
        this.mDataMapperImpl = mDataMapperImpl;
    }


    @Override
    public Completable insert(Post post) {
        Completable remoteSave = mPostDataStoreFactory.getPostRemoteDataStore().savePost(mDataMapperImpl.mapToDataModel(post));
        Completable cacheSave = mPostDataStoreFactory.getPostCacheDataStore().savePost(mDataMapperImpl.mapToDataModel(post));
        return remoteSave.andThen(cacheSave);
    }

    @Override
    public Completable insertAll(List<Post> posts) {
        List<DataPost> dataPostList = posts.stream().map(post -> mDataMapperImpl.mapToDataModel(post)).collect(Collectors.toList());
        return mPostDataStoreFactory.getPostCacheDataStore().saveAllPosts(dataPostList);
    }

    @Override
    public Completable delete(Post post) {
        Completable deleteRemote = mPostDataStoreFactory.getPostRemoteDataStore().deletePost(mDataMapperImpl.mapToDataModel(post));
        Completable deleteCache = mPostDataStoreFactory.getPostCacheDataStore().deletePost(mDataMapperImpl.mapToDataModel(post));
        return deleteRemote.andThen(deleteCache);
    }

    @Override
    public Completable update(Post post) {
        Completable updateRemote = mPostDataStoreFactory.getPostRemoteDataStore().updatePost(mDataMapperImpl.mapToDataModel(post));
        Completable updateCache = mPostDataStoreFactory.getPostCacheDataStore().updatePost(mDataMapperImpl.mapToDataModel(post));
        return updateRemote.andThen(updateCache);
    }

    @Override
    public Observable<Post> getPostById(int id) {
        return mPostDataStoreFactory.getPostCacheDataStore().isCached(id)
                .flatMapObservable(new io.reactivex.functions.Function<Boolean, ObservableSource<? extends Post>>() {
                    @Override
                    public ObservableSource<? extends Post> apply(Boolean aBoolean) throws Exception {
                        return mPostDataStoreFactory.retrieveDataStore(aBoolean).getPostById(id)
                                .flatMap(dataPost -> {
                                    Post post = mDataMapperImpl.mapFromDataModel(dataPost);
                                    return insert(post).andThen(Observable.just(post));
                                });
                    }
                });
    }

    @Override
    public Observable<List<Post>> getAllPosts() {
        return mPostDataStoreFactory.getPostCacheDataStore().isAllCached()
                .flatMapObservable(new io.reactivex.functions.Function<Boolean, ObservableSource<? extends List<Post>>>() {
                    @Override
                    public ObservableSource<? extends List<Post>> apply(Boolean aBoolean) throws Exception {
                        return mPostDataStoreFactory.retrieveDataStore(aBoolean).getAllPosts()
                                .flatMap(dataPostList -> {
                                    List<Post> postList = new ArrayList<>();
                                    for (DataPost dataPost : dataPostList) {
                                        postList.add(mDataMapperImpl.mapFromDataModel(dataPost));
                                    }
                                    return insertAll(postList).andThen(Observable.just(postList));
                                });
                    }
                });
    }
}