package com.vasyancoder.laba2.data.repositories;

import com.vasyancoder.laba2.data.datasource.HackathonRemoteDataSource;
import com.vasyancoder.laba2.data.protocols.HackathonListProtocol;
import com.vasyancoder.laba2.data.models.HackathonListItem;

import java.util.List;

public class HackathonListRepository implements HackathonListProtocol {

    private final HackathonRemoteDataSource hackathonRemoteDataSource = new HackathonRemoteDataSource();

    @Override
    public HackathonListItem getHackathonListItem(int position) {
        return hackathonRemoteDataSource.getHackathonList().get(position);
    }

    @Override
    public List<HackathonListItem> getHackathonList() {
        return hackathonRemoteDataSource.getHackathonList();
    }
}
