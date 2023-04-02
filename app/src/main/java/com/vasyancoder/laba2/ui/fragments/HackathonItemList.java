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

import com.vasyancoder.laba2.R;
import com.vasyancoder.laba2.databinding.FragmentHackathonItemListBinding;
import com.vasyancoder.laba2.data.models.HackathonListItem;
import com.vasyancoder.laba2.ui.stateholder.viewmodel.HackathonItemListViewModel;

public class HackathonItemList extends Fragment {

    private FragmentHackathonItemListBinding binding;
    private HackathonItemListViewModel viewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState
    ) {
        binding = FragmentHackathonItemListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(HackathonItemListViewModel.class);
        parseArgs();
        observeViewModel();
    }

    private void parseArgs() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int position = bundle.getInt(HackathonsListFragment.KEY_POS);
            viewModel.getHackathonListItem(position);
        }
    }

    private void observeViewModel() {
        viewModel.hackathonListItem().observe(getViewLifecycleOwner(), new Observer<HackathonListItem>() {
            @Override
            public void onChanged(HackathonListItem item) {
                binding.name.setText(item.getName());
                binding.company.setText(item.getCompany());
                binding.dateStartEnd.setText(item.getDateStartEnd());
                binding.languages.setText(item.getLanguages());
                if (item.isStatus()) {
                    binding.status.setText(getString(R.string.online));
                } else {
                    binding.status.setText(getString(R.string.offline));
                }
            }
        });
    }
}
