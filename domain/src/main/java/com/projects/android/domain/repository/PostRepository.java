package com.projects.android.domain.repository;

import com.projects.android.domain.model.Post;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface PostRepository {

    Completable insert(Post post);

    Completable insertAll(List<Post> posts);

    Completable delete(Post post);

    Completable update(Post post);

    Observable<Post> getPostById(int id);

    Observable<List<Post>> getAllPosts();
}
