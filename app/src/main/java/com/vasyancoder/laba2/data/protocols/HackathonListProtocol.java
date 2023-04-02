package com.vasyancoder.laba2.data.protocols;

import androidx.lifecycle.LiveData;

import com.vasyancoder.laba2.data.db.entities.HackathonListItem;

import java.util.List;

public interface HackathonListProtocol {

    LiveData<HackathonListItem> getHackathonListItem(int position);

    LiveData<List<HackathonListItem>> getHackathonList();

}
