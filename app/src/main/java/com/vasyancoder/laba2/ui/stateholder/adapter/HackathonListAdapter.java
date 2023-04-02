package com.vasyancoder.laba2.ui.stateholder.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vasyancoder.laba2.R;
import com.vasyancoder.laba2.databinding.ItemHackathonListBinding;
import com.vasyancoder.laba2.data.models.HackathonListItem;

import java.util.List;

public class HackathonListAdapter extends RecyclerView.Adapter<HackathonListAdapter.ViewHolder> {

    private final List<HackathonListItem> hackathonListItems;

    public OnHackathonItemListClickListener onHackathonItemListClickListener = null;

    public interface OnHackathonItemListClickListener {
        void onHackathonItemListClickListener(int position);
    }

    public HackathonListAdapter(List<HackathonListItem> hackathonListItems) {
        this.hackathonListItems = hackathonListItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemHackathonListBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HackathonListItem item = hackathonListItems.get(position);
        holder.binding.name.setText(item.getName());
        holder.binding.company.setText(item.getCompany());
        holder.binding.dateStartEnd.setText(item.getDateStartEnd());
        holder.binding.languages.setText(item.getLanguages());
        if (item.isStatus())
            holder.binding.status.setText(R.string.online);
        else
            holder.binding.status.setText(R.string.offline);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onHackathonItemListClickListener.onHackathonItemListClickListener(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return hackathonListItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemHackathonListBinding binding;

        public ViewHolder(@NonNull ItemHackathonListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
