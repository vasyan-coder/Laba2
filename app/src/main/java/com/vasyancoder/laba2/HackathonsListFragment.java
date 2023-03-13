package com.vasyancoder.laba2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.vasyancoder.laba2.databinding.FragmentHackathonsListBinding;
import com.vasyancoder.laba2.model.HackathonListAdapter;
import com.vasyancoder.laba2.model.HackathonListItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HackathonsListFragment extends Fragment {
    private FragmentHackathonsListBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentHackathonsListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        HackathonListAdapter adapter = new HackathonListAdapter(initList());
        binding.hackathonsList.setAdapter(adapter);
    }

    private List<HackathonListItem> initList() {
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

        return hackathonListItems;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
