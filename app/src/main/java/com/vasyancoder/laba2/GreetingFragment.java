package com.vasyancoder.laba2;

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

import com.vasyancoder.laba2.databinding.FragmentGreetingBinding;

public class GreetingFragment extends Fragment {
    private FragmentGreetingBinding binding;

    private static final String TAG = "GreetingFragment";

    @Override
    public void onAttach(@NonNull Context context) {
        Log.d(TAG, "onAttach");
        Toast.makeText(getContext(), "onAttach", Toast.LENGTH_SHORT).show();

        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "OnCreate. Fragment Lifecycle == " + getLifecycle().getCurrentState().toString());
        Log.d(TAG, "View Lifecylce == null");
        Toast.makeText(getContext(), "onCreate", Toast.LENGTH_SHORT).show();

        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView. Fragment Lifecycle == " + getLifecycle().getCurrentState().toString());
        Log.d(TAG, "View Lifecylce == " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
        Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_SHORT).show();

        binding = FragmentGreetingBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d(TAG, "onViewCreated. Fragment Lifecycle == " + getLifecycle().getCurrentState().toString());
        Log.d(TAG, "View Lifecylce == " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
        Toast.makeText(getContext(), "onViewCreated", Toast.LENGTH_SHORT).show();

        binding.createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_fragment, RegistrationFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
        });

        binding.logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_fragment, LoginFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
        });

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {

        Log.d(TAG, "onViewStateRestored. Fragment Lifecycle == " + getLifecycle().getCurrentState().toString());
        Log.d(TAG, "View Lifecylce == " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
        Toast.makeText(getContext(), "onViewStateRestored", Toast.LENGTH_SHORT).show();

        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onStart() {

        Log.d(TAG, "onStart. Fragment Lifecycle == " + getLifecycle().getCurrentState().toString());
        Log.d(TAG, "View Lifecylce == " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
        Toast.makeText(getContext(), "onStart", Toast.LENGTH_SHORT).show();

        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(TAG, "onResume. Fragment Lifecycle == " + getLifecycle().getCurrentState().toString());
        Log.d(TAG, "View Lifecylce == " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
        Toast.makeText(getContext(), "onResume", Toast.LENGTH_SHORT).show();

        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(TAG, "onPause. Fragment Lifecycle == " + getLifecycle().getCurrentState().toString());
        Log.d(TAG, "View Lifecylce == " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
        Toast.makeText(getContext(), "onPause", Toast.LENGTH_SHORT).show();

        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "onStop. Fragment Lifecycle == " + getLifecycle().getCurrentState().toString());
        Log.d(TAG, "View Lifecylce == " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
        Toast.makeText(getContext(), "onStop", Toast.LENGTH_SHORT).show();

        super.onStop();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSaveInstanceState. Fragment Lifecycle == " + getLifecycle().getCurrentState().toString());
        Log.d(TAG, "View Lifecylce == " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
        Toast.makeText(getContext(), "onSaveInstanceState", Toast.LENGTH_SHORT).show();

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView. Fragment Lifecycle == " + getLifecycle().getCurrentState().toString());
        Log.d(TAG, "View Lifecylce == " + getViewLifecycleOwner().getLifecycle().getCurrentState().toString());
        Toast.makeText(getContext(), "onDestroyView", Toast.LENGTH_SHORT).show();

        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy. Fragment Lifecycle == " + getLifecycle().getCurrentState().toString());
        Log.d(TAG, "View Lifecylce == null");
        Toast.makeText(getContext(), "onDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach");
        Toast.makeText(getContext(), "onDetach", Toast.LENGTH_SHORT).show();

        super.onDetach();
    }
}
