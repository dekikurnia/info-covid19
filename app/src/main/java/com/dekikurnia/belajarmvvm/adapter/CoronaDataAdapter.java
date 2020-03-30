package com.dekikurnia.belajarmvvm.adapter;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.dekikurnia.belajarmvvm.R;
import com.dekikurnia.belajarmvvm.databinding.CoronaListItemBinding;
import com.dekikurnia.belajarmvvm.model.Corona;

import java.util.ArrayList;
import java.util.List;

public class CoronaDataAdapter extends RecyclerView.Adapter<CoronaDataAdapter.CoronaViewHolder> {
    private ArrayList<Corona> corona;

    public CoronaDataAdapter(List<Corona> coronaList) {
    }

    @NonNull
    @Override
    public CoronaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        CoronaListItemBinding coronaListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.corona_list_item, viewGroup, false);
        return new CoronaViewHolder(coronaListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CoronaViewHolder coronaViewHolder, int i) {
        Corona c = corona.get(i);
        coronaViewHolder.coronaListItemBinding.setCorona(c);
    }

    @Override
    public int getItemCount() {
        if (corona != null) {
            return corona.size();
        } else {
            return 0;
        }
    }

    public void setCoronaList(ArrayList<Corona> corona) {
        this.corona = corona;
        notifyDataSetChanged();
    }

    static class CoronaViewHolder extends RecyclerView.ViewHolder {
        private CoronaListItemBinding coronaListItemBinding;

        CoronaViewHolder(@NonNull CoronaListItemBinding coronaListItemBinding) {
            super(coronaListItemBinding.getRoot());
            this.coronaListItemBinding = coronaListItemBinding;
        }
    }
}

