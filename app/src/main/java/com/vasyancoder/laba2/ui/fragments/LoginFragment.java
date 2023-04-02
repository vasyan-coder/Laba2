package com.vasyancoder.laba2.ui.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
import com.vasyancoder.laba2.databinding.FragmentLoginBinding;
import com.vasyancoder.laba2.ui.stateholder.viewmodel.LoginViewModel;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    private int maxLayoutHeight = 0;

    private static final String TAG = "LoginFragment";

    private LoginViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        parseArgs();
        addTextChangeListeners();
        observeViewModel();
        setButtonClickListeners();
        scrollDownWhenOpenKeyboard();

    }

    private void setButtonClickListeners() {
        binding.logInButton.setOnClickListener(view -> {
            if (viewModel.loginAccount(
                    binding.etLogin.getText().toString(),
                    binding.etPassword.getText().toString())
            ) {
                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_bottomNavFragment);
            }
        });
        binding.registration.setOnClickListener(
                view ->
                        Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registrationFragment)
        );
    }

    private void scrollDownWhenOpenKeyboard() {
        binding.getRoot().getViewTreeObserver().addOnGlobalLayoutListener(() -> {
            int heightDiff = binding.getRoot().getHeight();
            if (heightDiff > maxLayoutHeight)
                maxLayoutHeight = heightDiff;
            Log.d(TAG, "Layout height = " + heightDiff);
            if (heightDiff < maxLayoutHeight) {
                Log.d(TAG, "Open keyboard");
                scrollDownToMyPos();
            }
        });
    }

    private void scrollDownToMyPos() {
        binding.scrollView.postDelayed(() ->
                binding.scrollView.smoothScrollBy(0, (int) binding.logInButton.getY()), 0);
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
    }

    private void parseArgs() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String email = bundle.getString(RegistrationFragment.KEY_LOGIN);
            String pass = bundle.getString(RegistrationFragment.KEY_PASS);
            binding.etLogin.setText(email);
            binding.etPassword.setText(pass);
        }
    }
}