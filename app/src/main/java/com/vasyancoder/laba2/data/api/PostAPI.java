package com.vasyancoder.laba2.data.api;

import com.vasyancoder.laba2.data.models.Post;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostAPI {

    @GET("posts/1")
    Call<Post> getFirstPost();

}
