package com.projects.android.cache.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.projects.android.cache.model.CachePost;

import java.util.List;

@Dao
public interface PostDao {

    @Insert
    void savePost(CachePost cachePost);

    @Insert
    void saveAllPosts(List<CachePost> cachePosts);

    @Query("SELECT * FROM post ORDER BY id DESC")
    List<CachePost> getAllPost();

    @Query("SELECT * FROM post WHERE post.id = :postId")
    CachePost getPostById(int postId);

    @Delete
    void deletePost(CachePost cachePost);

    @Update
    void updatePost(CachePost cachePost);
}
