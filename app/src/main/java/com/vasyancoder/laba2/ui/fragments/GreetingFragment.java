package com.vasyancoder.laba2.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.vasyancoder.laba2.R;
import com.vasyancoder.laba2.databinding.FragmentGreetingBinding;

public class GreetingFragment extends Fragment {
    private FragmentGreetingBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentGreetingBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.createAccount.setOnClickListener(view1 ->
                Navigation.findNavController(view1).navigate(R.id.action_greetingFragment_to_registrationFragment));

        binding.logIn.setOnClickListener(view1 ->
                Navigation.findNavController(view1).navigate(R.id.action_greetingFragment_to_loginFragment));

    }
}
