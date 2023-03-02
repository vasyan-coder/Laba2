package com.vasyancoder.laba2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.vasyancoder.laba2.databinding.FragmentUserBinding;

public class UserFragment extends Fragment {
    private FragmentUserBinding binding;

    public static final String KEY_NAME = "user_login";

    private String userLogin = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentUserBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        parseArgs();

        binding.signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle result = new Bundle();
                result.putString(LoginFragment.KEY_LOGIN, userLogin);
                getParentFragmentManager().setFragmentResult(LoginFragment.KEY_RESULT, result);
                requireActivity().onBackPressed();
            }
        });

//        parseIntent();
    }

    private void parseArgs() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            userLogin = bundle.getString(LoginFragment.KEY_BUNDLE_EMAIL);
            binding.welcomeTextView.setText(getString(R.string.welcome, userLogin));
        } else {
            throw new RuntimeException("bundle is empty");
        }
    }

    public static UserFragment newInstance(String login) {
        UserFragment userFragment = new UserFragment();
        Bundle bundle = new Bundle();
        bundle.putString(LoginFragment.KEY_BUNDLE_EMAIL, login);
        userFragment.setArguments(bundle);
        return userFragment;
    }
}
