package com.orangetunisie.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WordViewHolder extends RecyclerView.ViewHolder {

    TextView word;

    public WordViewHolder(@NonNull View itemView) {
        super(itemView);
        word = itemView.findViewById(R.id.text_word);
    }
}
