package com.projects.android.data;

import android.util.Log;

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


/**
 * communicates with the domain layer by implementing PostRepository,
 * it uses the source factory to decide how to deal with data
 */
public class PostDataRepository implements PostRepository {

    private PostDataStoreFactory mPostDataStoreFactory;
    private DataMapperImpl mDataMapperImpl;

    @Inject
    public PostDataRepository(PostDataStoreFactory mPostDataStoreFactory, DataMapperImpl mDataMapperImpl) {
        this.mPostDataStoreFactory = mPostDataStoreFactory;
        this.mDataMapperImpl = mDataMapperImpl;
    }


    /**
     * @param post the model post that will be inserted
     * @return first insert it to the server and then to the database and return a completable that the task is completed
     */
    @Override
    public Completable insert(Post post) {
        Completable remoteSave = mPostDataStoreFactory.getPostRemoteDataStore().savePost(mDataMapperImpl.mapToDataModel(post));
        Completable cacheSave = mPostDataStoreFactory.getPostCacheDataStore().savePost(mDataMapperImpl.mapToDataModel(post));
        return remoteSave.andThen(cacheSave);
    }

    /**
     * @param posts list to be inserted to the database after getting it from the server
     * @return a completable that checks if the task is completed
     */
    @Override
    public Completable insertAll(List<Post> posts) {
        List<DataPost> dataPostList = posts.stream().map(post -> mDataMapperImpl.mapToDataModel(post)).collect(Collectors.toList());
        return mPostDataStoreFactory.getPostCacheDataStore().saveAllPosts(dataPostList);
    }

    /**
     * @param post the model post that will be deleted
     * @return first delete it from the server and then from the database and return a completable that the task is completed
     */
    @Override
    public Completable delete(Post post) {
        Completable deleteRemote = mPostDataStoreFactory.getPostRemoteDataStore().deletePost(mDataMapperImpl.mapToDataModel(post));
        Completable deleteCache = mPostDataStoreFactory.getPostCacheDataStore().deletePost(mDataMapperImpl.mapToDataModel(post));
        return deleteRemote.andThen(deleteCache);
    }

    /**
     * @param post the model post that will be updated
     * @return first update it from the server and then from the database and return a completable that the task is completed
     */
    @Override
    public Completable update(Post post) {
        Completable updateRemote = mPostDataStoreFactory.getPostRemoteDataStore().updatePost(mDataMapperImpl.mapToDataModel(post));
        Completable updateCache = mPostDataStoreFactory.getPostCacheDataStore().updatePost(mDataMapperImpl.mapToDataModel(post));
        return updateRemote.andThen(updateCache);
    }

    /**
     * @param id will be used to get the model
     * @return a model post from the server if it was not in the database
     * and insert it, if it existed in the database the method will return it from there
     */
    @Override
    public Observable<Post> getPostById(int id) {
        return mPostDataStoreFactory.getPostCacheDataStore().isCached(id)
                .flatMapObservable(aBoolean -> mPostDataStoreFactory.retrieveDataStore(aBoolean).getPostById(id)
                        .flatMap(dataPost -> {
                            Post post = mDataMapperImpl.mapFromDataModel(dataPost);
                            return insert(post).andThen(Observable.just(post));
                        }));
    }

    /**
     * @return a model list of posts from the server if it was not in the database
     * and insert it, if it existed in the database the method will return it from there
     */
    @Override
    public Observable<List<Post>> getAllPosts() {
        return mPostDataStoreFactory.getPostCacheDataStore().isAllCached()
                .flatMapObservable(aBoolean -> mPostDataStoreFactory.retrieveDataStore(aBoolean).getAllPosts()
                        .flatMap(dataPostList -> {
                            List<Post> postList = new ArrayList<>();
                            for (DataPost dataPost : dataPostList) {
                                postList.add(mDataMapperImpl.mapFromDataModel(dataPost));
                            }
                            return insertAll(postList).andThen(Observable.just(postList));
                        }));
    }

    /**
     *
     * @return the count of items in the database
     */
    @Override
    public Observable<Integer> getCount() {
        return mPostDataStoreFactory.getPostCacheDataStore().getCount();
    }


}