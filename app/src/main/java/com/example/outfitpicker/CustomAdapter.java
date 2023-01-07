package com.example.outfitpicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList outfit_id, outfit_title, outfit_pieces;

    CustomAdapter(Context context, ArrayList outfit_id, ArrayList outfit_title, ArrayList outfit_pieces) {
        this.context = context;
        this.outfit_id = outfit_id;
        this.outfit_title = outfit_title;
        this.outfit_pieces = outfit_pieces;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.outfit_id_txt.setText(String.valueOf(outfit_id.get(position)));
        holder.outfit_title_txt.setText(String.valueOf(outfit_title.get(position)));
        holder.outfit_pieces_txt.setText(String.valueOf(outfit_pieces.get(position)));
    }

    @Override
    public int getItemCount() {
        return outfit_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView outfit_id_txt, outfit_title_txt, outfit_pieces_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            outfit_id_txt = itemView.findViewById(R.id.outfit_id_txt);
            outfit_title_txt = itemView.findViewById(R.id.outfit_title_txt);
            outfit_pieces_txt = itemView.findViewById(R.id.outfit_pieces_txt);
        }
    }
}
