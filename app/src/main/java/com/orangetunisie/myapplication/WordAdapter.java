package com.orangetunisie.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordAdapter extends RecyclerView.Adapter<WordViewHolder> {

    private LinkedList<String> data;

    public WordAdapter(LinkedList<String> data){
        this.data = data;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final WordViewHolder holder, int position) {
        String s = data.get(position);
        holder.word.setText(s);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
