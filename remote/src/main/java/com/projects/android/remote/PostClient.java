package com.projects.android.remote;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts/";
    private static final Object lock = new Object();
    private static PostService serviceInstance = null;
    private static Retrofit retrofit = null;

    private static OkHttpClient createClient(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
    }

    public static PostService getServiecInstance() {
        synchronized (lock) {
            if (serviceInstance == null) {
                serviceInstance = createRetrofitClient().create(PostService.class);
            }
        }
        return serviceInstance;
    }

    private static Retrofit createRetrofitClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(createClient())
                    .build();
        }
        return retrofit;
    }

}
