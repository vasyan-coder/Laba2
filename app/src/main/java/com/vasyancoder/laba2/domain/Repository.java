package com.vasyancoder.laba2.domain;

import com.vasyancoder.laba2.domain.entity.HackathonListItem;
import com.vasyancoder.laba2.domain.entity.LoginAccount;
import com.vasyancoder.laba2.domain.entity.RegistrationAccount;

import java.util.List;

public interface Repository {

    boolean createAccount(RegistrationAccount registrationAccount);

    HackathonListItem getHackathonListItem(int position);

    List<HackathonListItem> getHackathonList();

    boolean loginAccount(LoginAccount loginAccount);
}
