package com.vasyancoder.laba2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationBarView;
import com.vasyancoder.laba2.databinding.FragmentBottomNavBinding;

public class BottomNavFragment extends Fragment {

    private FragmentBottomNavBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentBottomNavBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        requireActivity().getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_bottom_nav_container, HackathonsListFragment.class, null)
                .commit();

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.item_list) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_bottom_nav_container, new HackathonsListFragment())
                        .commit();
                return true;
            }
            if (item.getItemId() == R.id.item_calendar) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_bottom_nav_container, new CalendarFragment())
                        .commit();
                return true;
            }
            return false;
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
