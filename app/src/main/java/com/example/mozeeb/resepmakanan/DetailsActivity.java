package com.example.mozeeb.resepmakanan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.gambar_details)
    ImageView gambarDetails;
    @BindView(R.id.judul_details)
    TextView judulDetails;
    @BindView(R.id.bahan_details)
    TextView bahanDetails;
    @BindView(R.id.membuat_details)
    TextView membuatDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);


        Glide.with(this).load(getIntent().getIntExtra("gambar", 0)).into(gambarDetails);
        judulDetails.setText(getIntent().getStringExtra("judul"));
        bahanDetails.setText(getIntent().getStringExtra("bahan"));
        membuatDetails.setText(getIntent().getStringExtra("membuat"));

    }
}
