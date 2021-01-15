package com.example.cybergeek;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class BloggerAPI {
    public static final String key = "AIzaSyCf5X6RGhbTtHxor4qNw5EhlEFljAAOzqo";
    public static final String url = "https://www.googleapis.com/blogger/v3/blogs/3731950133744224736/posts/";


    public static PostService postService = null;

    public static PostService getService() {
        if (postService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            postService = retrofit.create(PostService.class);
        }
        return postService;
    }

    //Create Interface for defining methods which we are using in the project & then provide implementation of interface
    public interface PostService {

        @GET("?key=" + key)
        Call<PostList> getPostList();
    }
}