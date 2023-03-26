package com.vasyancoder.laba2.domain.usecase;

import com.vasyancoder.laba2.domain.repository.HackathonListRepository;
import com.vasyancoder.laba2.domain.entity.HackathonListItem;

import java.util.List;

public class GetHackathonListUseCase {

    private final HackathonListRepository repository;

    public GetHackathonListUseCase(HackathonListRepository repository) {
        this.repository = repository;
    }

    public List<HackathonListItem> getHackathonList() {
        return repository.getHackathonList();
    }
}
