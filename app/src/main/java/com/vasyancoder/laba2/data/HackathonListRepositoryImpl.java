package com.vasyancoder.laba2.data;

import com.vasyancoder.laba2.data.datasource.HackathonRemoteDataSource;
import com.vasyancoder.laba2.domain.repository.HackathonListRepository;
import com.vasyancoder.laba2.domain.entity.HackathonListItem;

import java.util.List;

public class HackathonListRepositoryImpl implements HackathonListRepository {

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
