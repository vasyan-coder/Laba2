package com.vasyancoder.laba2.ui.fragments;


import static java.net.Proxy.Type.HTTP;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.vasyancoder.laba2.CalendarService;
import com.vasyancoder.laba2.R;
import com.vasyancoder.laba2.data.models.Post;
import com.vasyancoder.laba2.databinding.FragmentCalendarBinding;
import com.vasyancoder.laba2.ui.stateholder.viewmodel.CalendarViewModel;
import com.vasyancoder.laba2.ui.stateholder.viewmodel.HackathonsListViewModel;

public class CalendarFragment extends Fragment {
    private FragmentCalendarBinding binding;

    private static final String CHANNEL_ID = "calendar";

    private CalendarViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCalendarBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(CalendarViewModel.class);
        createNotificationChannel();

        viewModel.getPostLiveData().observe(getViewLifecycleOwner(), new Observer<Post>() {
            @Override
            public void onChanged(Post post) {
                binding.textGet.setText("Get: " + post.getTitle());
            }
        });

        AnimatedVectorDrawable drawable = (AnimatedVectorDrawable) binding.animDone.getDrawable();
        drawable.start();

        binding.notifyBtn.setOnClickListener(view1 -> {
            showNotification();

            Intent intent = new Intent(requireContext(), CalendarService.class);
            requireActivity().startService(intent);
        });
        binding.shareBtn.setOnClickListener(view1 -> {
            Intent textIntent = new Intent(Intent.ACTION_SEND);
            textIntent.setType("text/plain");
            textIntent.putExtra(Intent.EXTRA_TEXT, "Присоединяйтесь к HackApp");
            requireActivity().startActivity(textIntent);
        });
    }


    private void showNotification() {
        Notification notification = new NotificationCompat.Builder(requireContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.icon_calendar)
                .setContentText("Запись на хакатон прошла успешно")
                .setContentTitle("Успешно")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build();

        NotificationManager notificationManager =
                (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(1, notification);

    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "calendar",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            NotificationManager notificationManager =
                    (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
