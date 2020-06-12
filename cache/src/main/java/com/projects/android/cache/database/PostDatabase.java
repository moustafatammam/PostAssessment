package com.projects.android.cache.database;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.projects.android.cache.dao.PostDao;
import com.projects.android.cache.model.CachePost;

import javax.inject.Inject;

@Database(entities = {CachePost.class},
version = 1,
exportSchema = false)
public abstract class PostDatabase extends RoomDatabase {

    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "PostDatabase";

    private static PostDatabase sDatabaseInstance;

    @Inject
    public PostDatabase() {
    }

    public static PostDatabase getInstance(Context context){

        if(sDatabaseInstance == null){
            synchronized (LOCK){
                sDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                        PostDatabase.class, PostDatabase.DATABASE_NAME)
                        .build();
            }
        }
        return sDatabaseInstance;
    }

    public abstract PostDao postDao();
}
