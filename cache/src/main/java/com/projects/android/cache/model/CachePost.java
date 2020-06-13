package com.projects.android.cache.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "post")
public class CachePost {


    @PrimaryKey
    private int id;

    private int isDeleted;

    private String title;
    private String body;

    public CachePost(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
