package com.vasyancoder.laba2.domain.usecase;

import com.vasyancoder.laba2.domain.Repository;
import com.vasyancoder.laba2.domain.entity.HackathonListItem;

public class GetHackathonListItemUseCase {

    private final Repository repository;

    public GetHackathonListItemUseCase(Repository repository) {
        this.repository = repository;
    }

    public HackathonListItem getHackathonListItem(int position) {
        return repository.getHackathonListItem(position);
    }
}
