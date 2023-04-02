package com.vasyancoder.laba2.data.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.vasyancoder.laba2.data.datasource.HackathonRemoteDataSource;
import com.vasyancoder.laba2.data.db.HackathonDatabase;
import com.vasyancoder.laba2.data.db.dao.HackathonDao;
import com.vasyancoder.laba2.data.protocols.HackathonListProtocol;
import com.vasyancoder.laba2.data.db.entities.HackathonListItem;

import java.util.List;

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
}
