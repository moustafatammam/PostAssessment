package com.projects.android.remote;

import com.projects.android.remote.model.RemotePost;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PostService {

    @GET(".")
    Observable<List<RemotePost>> getAllPosts();

    @GET("{id}")
    Observable<RemotePost> getPostById(@Path("id") int id);

    @POST()
    Completable savePost(@Body RemotePost remotePost);

    @PUT("{id}")
    Completable updatePost(@Path("id") int id, @Body RemotePost remotePost);

    @DELETE("{id}")
    Completable deletePost(@Path("id") int id);

}
