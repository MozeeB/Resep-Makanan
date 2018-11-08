package com.example.mozeeb.resepmakanan;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterResep extends RecyclerView.Adapter<AdapterResep.ViewHolder> {
    Context context;
    String[][] data;
    int[] gambar;

    public AdapterResep(Context context, String[][] data, int[] gambar) {
        this.context = context;
        this.data = data;
        this.gambar = gambar;
    }

    @NonNull
    @Override
    public AdapterResep.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.design_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterResep.ViewHolder viewHolder, final int i) {
        viewHolder.btnjudul.setText(data[i][0]);
        Glide.with(context).load(gambar[i]).into(viewHolder.imgGambar);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("gambar",gambar[i]);
                intent.putExtra("judul",data[i][0]);
                intent.putExtra("bahan", data[i][1]);
                intent.putExtra("membuat", data[i][2]);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gambar.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView btnjudul;
        ImageView imgGambar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgGambar = itemView.findViewById(R.id.gambaryagan);
            btnjudul = itemView.findViewById(R.id.judulnya);
        }
    }
}

