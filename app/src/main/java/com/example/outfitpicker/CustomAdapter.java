package com.example.outfitpicker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList outfit_id, outfit_title, outfit_pieces;

    CustomAdapter(Activity activity, Context context, ArrayList outfit_id, ArrayList outfit_title, ArrayList outfit_pieces) {
        this.activity = activity;
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

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.outfit_id_txt.setText(String.valueOf(outfit_id.get(position)));
        holder.outfit_title_txt.setText(String.valueOf(outfit_title.get(position)));
        holder.outfit_pieces_txt.setText(String.valueOf(outfit_pieces.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(outfit_id.get(holder.getAdapterPosition())));
                intent.putExtra("title", String.valueOf(outfit_title.get(holder.getAdapterPosition())));
                intent.putExtra("pieces", String.valueOf(outfit_pieces.get(holder.getAdapterPosition())));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return outfit_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView outfit_id_txt, outfit_title_txt, outfit_pieces_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            outfit_id_txt = itemView.findViewById(R.id.outfit_id_txt);
            outfit_title_txt = itemView.findViewById(R.id.outfit_title_txt);
            outfit_pieces_txt = itemView.findViewById(R.id.outfit_pieces_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);

            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }
    }
}
