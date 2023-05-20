package com.vasyancoder.laba2.data.api;

import com.vasyancoder.laba2.data.models.Post;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PostAPI {

    @GET("posts/1")
    Call<Post> getFirstPost();

    @POST("posts")
    Call<Post> pushPost(@Body Post post);

}
