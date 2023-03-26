package com.vasyancoder.laba2.domain.usecase;

import com.vasyancoder.laba2.domain.Repository;
import com.vasyancoder.laba2.domain.entity.HackathonListItem;

import java.util.List;

public class GetHackathonListUseCase {

    private final Repository repository;

    public GetHackathonListUseCase(Repository repository) {
        this.repository = repository;
    }

    public List<HackathonListItem> getHackathonList() {
        return repository.getHackathonList();
    }
}
