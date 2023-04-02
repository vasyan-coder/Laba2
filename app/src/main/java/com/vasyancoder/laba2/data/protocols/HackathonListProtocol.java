package com.vasyancoder.laba2.data.protocols;

import com.vasyancoder.laba2.data.models.HackathonListItem;

import java.util.List;

public interface HackathonListProtocol {

    HackathonListItem getHackathonListItem(int position);

    List<HackathonListItem> getHackathonList();

}
