package com.vasyancoder.laba2.ui.stateholder.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vasyancoder.laba2.data.models.Post;
import com.vasyancoder.laba2.data.repositories.HackathonListRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CalendarViewModel extends AndroidViewModel {

    public CalendarViewModel(@NonNull Application application) {
        super(application);
        repository.getFirstPost().enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    Post post = response.body();
                    postLiveData.setValue(post);
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
            }
        });

    }

    private final HackathonListRepository repository = new HackathonListRepository(getApplication());


    private MutableLiveData<Post> postLiveData = new MutableLiveData<>();


    public LiveData<Post> getPostLiveData() {
        return postLiveData;
    }
}
