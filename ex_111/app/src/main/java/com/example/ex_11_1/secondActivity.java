package com.example.ex_11_1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class secondActivity extends AppCompatActivity
{
    int pos;
    Context context;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Intent intent = getIntent();
        int pos = intent.getIntExtra("pos", 0);

        View secondView = (View) View.inflate(this, R.layout.second, null);
        ImageView imgView = (ImageView) secondView.findViewById(R.id.ivPoster);
        imgView.setImageResource(((MainActivity)context).posterID[pos]);
    }
}
