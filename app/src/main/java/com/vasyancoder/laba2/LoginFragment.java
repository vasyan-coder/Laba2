package com.vasyancoder.laba2;

import android.content.res.ColorStateList;
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
import androidx.navigation.Navigation;

import com.vasyancoder.laba2.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    private int maxLayoutHeight = 0;

    private static final String TAG = "LoginFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        parseArgs();

        setButtonClickListeners();

        clearListenerLoginError();
        clearListenerPasswordError();

        scrollDownWhenOpenKeyboard();

    }

    private void setButtonClickListeners() {
        binding.logInButton.setOnClickListener(view1 -> checkFields(view1));
        binding.registration.setOnClickListener(
                view1 ->
                        Navigation.findNavController(view1).navigate(R.id.action_loginFragment_to_registrationFragment)
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
        binding.scrollView.postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.scrollView.smoothScrollBy(0, (int) binding.logInButton.getY());
            }
        }, 0);
    }

    private void checkFields(View view1) {
        if (binding.etLogin.getText().toString().length() != 0 &&
                binding.etPassword.getText().toString().length() != 0) {

            Navigation.findNavController(view1).navigate(R.id.action_loginFragment_to_bottomNavFragment);

        } else if (binding.etLogin.getText().toString().length() == 0 &&
                binding.etPassword.getText().toString().length() != 0) {

            binding.etLoginLayout.setHelperText(getString(R.string.warning_fill));
            binding.etLoginLayout.setHelperTextColor(ColorStateList.valueOf(requireContext().getColor(R.color.red)));
        } else if (binding.etPassword.getText().toString().length() == 0 &&
                binding.etLogin.getText().toString().length() != 0) {

            binding.etPasswordLayout.setHelperText(getString(R.string.warning_fill));
            binding.etPasswordLayout.setHelperTextColor(ColorStateList.valueOf(requireContext().getColor(R.color.red)));
        } else {
            binding.etPasswordLayout.setHelperText(getString(R.string.warning_fill));
            binding.etPasswordLayout.setHelperTextColor(ColorStateList.valueOf(requireContext().getColor(R.color.red)));
            binding.etLoginLayout.setHelperText(getString(R.string.warning_fill));
            binding.etLoginLayout.setHelperTextColor(ColorStateList.valueOf(requireContext().getColor(R.color.red)));
        }
    }

    private void clearListenerLoginError() {
        binding.etLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0) {
                    binding.etLoginLayout.setHelperText("");
                    binding.etLoginLayout.setHelperTextColor(ColorStateList.valueOf(requireContext().getColor(R.color.red)));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void clearListenerPasswordError() {
        binding.etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.etPasswordLayout.setHelperText("");
                binding.etPasswordLayout.setHelperTextColor(ColorStateList.valueOf(requireContext().getColor(R.color.red)));
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void parseArgs() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String email = bundle.getString(RegistrationFragment.KEY_EMAIL);
            String pass = bundle.getString(RegistrationFragment.KEY_PASS);
            binding.etLogin.setText(email);
            binding.etPassword.setText(pass);
        }
    }
}
