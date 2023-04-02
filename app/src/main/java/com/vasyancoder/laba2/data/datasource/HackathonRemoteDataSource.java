package com.vasyancoder.laba2.data.datasource;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.vasyancoder.laba2.data.models.HackathonListItem;

import java.util.ArrayList;
import java.util.List;

public class HackathonRemoteDataSource {

    public LiveData<List<HackathonListItem>> getHackathonList() {
        List<HackathonListItem> hackathonListItems = new ArrayList<>();

        String[] names = {"TRUE TECH HACK", "BRAINSTORM"};
        String[] companies = {"МТС", "ITПЛАНЕТА", "VK", "TINKOFF"};
        String[] dates = {
                "Регистрация до: 22 марта\nПроходит: с 24 до 30 марта",
                "Регистрация до: 28 января\nПроходит: с 1 февраля до 10 апреля"
        };
        String[] languages = {"RU", "EN"};
        Boolean[] statuses = {true, false};

        for (int i = 0; i < 50; i++) {
            hackathonListItems.add(
                    new HackathonListItem(
                            names[(int) (Math.random() * names.length)],
                            companies[(int) (Math.random() * companies.length)],
                            dates[(int) (Math.random() * dates.length)],
                            languages[(int) (Math.random() * languages.length)],
                            statuses[(int) (Math.random() * statuses.length)]
                    )
            );
        }
        MutableLiveData<List<HackathonListItem>> hackathonListItemsLD = new MutableLiveData<>();
        hackathonListItemsLD.setValue(hackathonListItems);
        return hackathonListItemsLD;
    }
}
