package com.vasyancoder.laba2.ui.stateholder.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.vasyancoder.laba2.data.repositories.HackathonListRepository;
import com.vasyancoder.laba2.data.models.HackathonListItem;

import java.util.List;

public class HackathonsListViewModel extends ViewModel {

    private final HackathonListRepository repository = new HackathonListRepository();

    public LiveData<List<HackathonListItem>> hackathonList = repository.getHackathonList();
}
