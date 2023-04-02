package com.vasyancoder.laba2.ui.stateholder.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.vasyancoder.laba2.data.repositories.HackathonListRepository;
import com.vasyancoder.laba2.data.db.entities.HackathonListItem;

import java.util.List;

public class HackathonsListViewModel extends AndroidViewModel {

    private final HackathonListRepository repository = new HackathonListRepository(getApplication());

    public LiveData<List<HackathonListItem>> hackathonList = repository.getHackathonList();

    public HackathonsListViewModel(@NonNull Application application) {
        super(application);
    }
}
