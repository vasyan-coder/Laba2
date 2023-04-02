package com.vasyancoder.laba2.ui.stateholder.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vasyancoder.laba2.data.repositories.HackathonListRepository;
import com.vasyancoder.laba2.data.models.HackathonListItem;

public class HackathonItemListViewModel extends ViewModel {

    private final HackathonListRepository repository = new HackathonListRepository();

    private final MutableLiveData<HackathonListItem> _hackathonListItem = new MutableLiveData<>();

    public LiveData<HackathonListItem> hackathonListItem() {
        return _hackathonListItem;
    }

    public void getHackathonListItem(int position) {
        _hackathonListItem.setValue(repository.getHackathonListItem(position));
    }
}
