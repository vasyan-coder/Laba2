package com.vasyancoder.laba2.domain.usecase;

import com.vasyancoder.laba2.domain.HackathonListRepository;
import com.vasyancoder.laba2.domain.entity.HackathonListItem;

public class GetHackathonListItemUseCase {

    private final HackathonListRepository repository;

    public GetHackathonListItemUseCase(HackathonListRepository repository) {
        this.repository = repository;
    }

    public HackathonListItem getHackathonListItem(int position) {
        return repository.getHackathonListItem(position);
    }
}
