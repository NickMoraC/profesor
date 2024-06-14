package com.uniguajira.proyectofinalv2.views.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.uniguajira.proyectofinalv2.R;
import com.uniguajira.proyectofinalv2.databinding.MainRevistasRowsBinding;
import com.uniguajira.proyectofinalv2.repositories.room.entities.Revistas;
import com.uniguajira.proyectofinalv2.views.callback.RevistasClickCallback;

import java.util.List;

public class RevistasAdapter extends RecyclerView.Adapter<RevistasAdapter.RevistasViewHolder>{
    List<? extends Revistas> revistasList;

    @Nullable
    private final RevistasClickCallback revistasClickCallback;

    public RevistasAdapter(@Nullable RevistasClickCallback revistasClickCallback) {
        this.revistasClickCallback = revistasClickCallback;
    }

    public void setRevistasList(final List<? extends Revistas> revistas) {
        if (this.revistasList == null) {
            this.revistasList = revistas;
            notifyItemRangeInserted(0, revistasList.size());
        } else {
            this.revistasList = revistas;
        }
    }

    @Override
    public RevistasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MainRevistasRowsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.main_revistas_rows,parent, false);
        binding.setCallback(revistasClickCallback);
        return new RevistasViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RevistasViewHolder holder, int position) {
        holder.binding.setRevistas(revistasList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return revistasList == null ? 0 : revistasList.size();
    }

    public void removeItem(int position) {
        revistasList.remove(position);
        notifyItemRemoved(position);
    }

    static class RevistasViewHolder extends RecyclerView.ViewHolder {
        final MainRevistasRowsBinding binding;
        public RevistasViewHolder(MainRevistasRowsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}