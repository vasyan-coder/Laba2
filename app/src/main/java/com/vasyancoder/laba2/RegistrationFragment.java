package com.vasyancoder.laba2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.vasyancoder.laba2.databinding.FragmentRegistrationBinding;

public class RegistrationFragment extends Fragment {

    private FragmentRegistrationBinding binding;

    private static final String TAG = "RegistrationFragment";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASS = "password";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.signInButton.setOnClickListener(view1 -> {
            String email = binding.etLogin.getText().toString();
            String pass = binding.etPassword.getText().toString();

            Bundle bundle = new Bundle();
            bundle.putString(KEY_EMAIL, email);
            bundle.putString(KEY_PASS, pass);

            Navigation.findNavController(view1)
                    .navigate(R.id.action_registrationFragment_to_loginFragment, bundle);
        });
    }
}
