package com.vasyancoder.laba2.ui.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.vasyancoder.laba2.databinding.FragmentRegistrationBinding;
import com.vasyancoder.laba2.ui.stateholder.viewmodel.RegistrationViewModel;

public class RegistrationFragment extends Fragment {

    private static final String SHARED_PREF_LOGIN = "login";
    private FragmentRegistrationBinding binding;

    public static final String KEY_LOGIN = "login";
    public static final String KEY_PASS = "password";

    private RegistrationViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(RegistrationViewModel.class);
        addTextChangeListeners();
        observeViewModel();

        // read
        SharedPreferences sharedPrefRead =
                requireActivity().getPreferences(Context.MODE_PRIVATE);
        String loginSP = sharedPrefRead.getString(SHARED_PREF_LOGIN, "");
        binding.etLogin.setText(loginSP);

        binding.signInButton.setOnClickListener(view1 -> {
            String login = binding.etLogin.getText().toString();
            String pass = binding.etPassword.getText().toString();
            String email = binding.etEmail.getText().toString();
            String phone = binding.etPhone.getText().toString();
            String name = binding.etName.getText().toString();
            String surname = binding.etSurname.getText().toString();

            // write
            SharedPreferences sharedPrefWrite =
                    requireActivity().getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPrefWrite.edit();
            editor.putString(SHARED_PREF_LOGIN,
                    login);
            editor.apply();


            if (viewModel.createAccount(
                    login,
                    pass,
                    email,
                    phone,
                    name,
                    surname
            )) {
                Bundle bundle = new Bundle();
                bundle.putString(KEY_LOGIN, login);
                bundle.putString(KEY_PASS, pass);
                Navigation.findNavController(view1)
                        .navigate(R.id.action_registrationFragment_to_loginFragment, bundle);
            }
        });
    }

    private void observeViewModel() {
        viewModel.errorInputLogin().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                String message = aBoolean ? getString(R.string.necessarily) : null;
                binding.etLogin.setError(message);
            }
        });
        viewModel.errorInputPass().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                String message = aBoolean ? getString(R.string.necessarily) : null;
                binding.etPassword.setError(message);
            }
        });
        viewModel.errorInputEmail().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                String message = aBoolean ? getString(R.string.necessarily) : null;
                binding.etEmail.setError(message);
            }
        });
        viewModel.errorInputPhone().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                String message = aBoolean ? getString(R.string.necessarily) : null;
                binding.etPhone.setError(message);
            }
        });
    }

    private void addTextChangeListeners() {
        viewModel.errorInputLogin().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                binding.etLogin.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        viewModel.resetErrorInputLogin();
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                    }
                });
                binding.etPassword.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        viewModel.resetErrorInputPass();
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                    }
                });
                binding.etEmail.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        viewModel.resetErrorInputEmail();
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                    }
                });
                binding.etPhone.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        viewModel.resetErrorInputPhone();
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                    }
                });
            }
        });
    }

}
