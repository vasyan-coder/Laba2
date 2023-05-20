package com.vasyancoder.laba2.data.protocols;

import androidx.lifecycle.LiveData;

import com.vasyancoder.laba2.data.db.entities.HackathonListItem;
import com.vasyancoder.laba2.data.models.Post;

import java.util.List;

import retrofit2.Call;

public interface HackathonListProtocol {

    LiveData<HackathonListItem> getHackathonListItem(int position);

    LiveData<List<HackathonListItem>> getHackathonList();

    Call<Post> getFirstPost();

}
