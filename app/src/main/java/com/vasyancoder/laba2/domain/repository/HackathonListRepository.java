package com.vasyancoder.laba2.domain.repository;

import com.vasyancoder.laba2.domain.entity.HackathonListItem;

import java.util.List;

public interface HackathonListRepository {

    HackathonListItem getHackathonListItem(int position);

    List<HackathonListItem> getHackathonList();

}
