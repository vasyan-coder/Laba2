package com.vasyancoder.laba2.data.repositories;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.vasyancoder.laba2.data.api.PostAPI;
import com.vasyancoder.laba2.data.api.RetrofitFactory;
import com.vasyancoder.laba2.data.datasource.HackathonRemoteDataSource;
import com.vasyancoder.laba2.data.db.HackathonDatabase;
import com.vasyancoder.laba2.data.db.dao.HackathonDao;
import com.vasyancoder.laba2.data.models.Post;
import com.vasyancoder.laba2.data.protocols.HackathonListProtocol;
import com.vasyancoder.laba2.data.db.entities.HackathonListItem;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HackathonListRepository implements HackathonListProtocol {

    private final Context context;

    private List<HackathonListItem> list;

    private final HackathonRemoteDataSource hackathonRemoteDataSource;

    public HackathonListRepository(Context context) {
        this.context = context;
        hackathonRemoteDataSource = new HackathonRemoteDataSource(context);
    }

    @Override
    public LiveData<HackathonListItem> getHackathonListItem(int position) {
        return hackathonRemoteDataSource.getHackathonListItem(position);
    }

    @Override
    public LiveData<List<HackathonListItem>> getHackathonList() {
        list = hackathonRemoteDataSource.getHackathonList().getValue();
        return hackathonRemoteDataSource.getHackathonList();
    }

    @Override
    public Call<Post> getFirstPost() {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        PostAPI postAPI = retrofit.create(PostAPI.class);
        Call<Post> call = postAPI.getFirstPost();
        return call;
    }

    @Override
    public Call<Post> pushPost(Post post) {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        PostAPI postAPI = retrofit.create(PostAPI.class);
        Call<Post> call = postAPI.pushPost(post);
        return call;
    }

    @Override
    public Call<List<Post>> getAllPosts() {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        PostAPI postAPI = retrofit.create(PostAPI.class);
        Call<List<Post>> call = postAPI.getAllPosts();
        return call;
    }
}
