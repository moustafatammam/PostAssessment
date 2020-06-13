package com.projects.android.cache.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.projects.android.cache.model.CachePost;

import java.util.List;

@Dao
public interface PostDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void savePost(CachePost cachePost);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void saveAllPosts(List<CachePost> cachePosts);

    @Query("SELECT * FROM post WHERE isDeleted = 0 ORDER BY id DESC")
    List<CachePost> getAllPost();

    @Query("SELECT * FROM post WHERE post.id = :postId")
    CachePost getPostById(int postId);

    @Query("UPDATE post SET isDeleted = 1 WHERE id = :postID")
    void deletePost(int postID);

    @Query("SELECT COUNT(*) FROM post")
    Integer getRowCount();

    @Query("UPDATE post SET title = :updateTitle, body = :updateBody WHERE id = :updateId")
    void updatePost(String updateTitle, String updateBody, int updateId);
}
