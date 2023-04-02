package com.vasyancoder.laba2.ui.stateholder.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vasyancoder.laba2.data.repositories.HackathonListRepository;
import com.vasyancoder.laba2.data.db.entities.HackathonListItem;

public class HackathonItemListViewModel extends AndroidViewModel {

    private final HackathonListRepository repository = new HackathonListRepository(getApplication());

    public LiveData<HackathonListItem> hackathonListItem;

    public HackathonItemListViewModel(@NonNull Application application) {
        super(application);
    }

    public void getHackathonListItem(int position) {
        hackathonListItem = repository.getHackathonListItem(position);
    }
}