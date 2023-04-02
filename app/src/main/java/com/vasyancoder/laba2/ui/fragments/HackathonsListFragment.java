package com.vasyancoder.laba2.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.vasyancoder.laba2.R;
import com.vasyancoder.laba2.data.db.entities.HackathonListItem;
import com.vasyancoder.laba2.databinding.FragmentHackathonsListBinding;
import com.vasyancoder.laba2.ui.stateholder.adapter.HackathonListAdapter;
import com.vasyancoder.laba2.ui.stateholder.viewmodel.HackathonsListViewModel;

import java.util.List;

public class HackathonsListFragment extends Fragment {
    private FragmentHackathonsListBinding binding;
    public static final String KEY_POS = "position";

    private HackathonsListViewModel viewModel;

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
        viewModel = new ViewModelProvider(this).get(HackathonsListViewModel.class);
        viewModel.hackathonList.observe(getViewLifecycleOwner(), new Observer<List<HackathonListItem>>() {
            @Override
            public void onChanged(List<HackathonListItem> hackathonListItems) {
                HackathonListAdapter adapter = new HackathonListAdapter(hackathonListItems);
                adapter.onHackathonItemListClickListener = new HackathonListAdapter.OnHackathonItemListClickListener() {
                    @Override
                    public void onHackathonItemListClickListener(int position) {
                        Bundle bundle = new Bundle();
                        bundle.putInt(KEY_POS, position);
                        Navigation.findNavController(requireView())
                                .navigate(R.id.action_fragmentHackathonsList_to_hackathonItemList, bundle);
                    }
                };
                binding.hackathonsList.setAdapter(adapter);
            }
        });


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
