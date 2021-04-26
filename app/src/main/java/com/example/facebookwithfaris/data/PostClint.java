package com.example.facebookwithfaris.data;

import android.util.Log;

import com.example.facebookwithfaris.pojo.PostModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClint {

    private static final String TAG = "PostClint";
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private PostInterface postInterface;
    private static PostClint INSTANCE;

    public PostClint() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }

    public static PostClint getINSTANCE() {
        Log.d(TAG, "getINSTANCE: getInstence method got called");
        if (null == INSTANCE){
            INSTANCE = new PostClint();
        }
        return INSTANCE;
    }

    public Single<List<PostModel>> getPosts(){
        Log.d(TAG, "getPosts: get posts in postclint got called");
        return postInterface.getPosts();
    }
}









