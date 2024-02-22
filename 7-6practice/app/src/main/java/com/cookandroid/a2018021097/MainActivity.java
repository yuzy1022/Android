package com.cookandroid.a2018021097;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup rdogrp;
    Button btn;
    ImageView image;
    RadioButton apple, banana, grape, orange, pineapple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("2018021097 박상원");
        btn = (Button)findViewById(R.id.btn);
        rdogrp = (RadioGroup)findViewById(R.id.rdogrp);
        apple = (RadioButton)findViewById(R.id.apple);
        banana = (RadioButton)findViewById(R.id.banana);
        grape = (RadioButton)findViewById(R.id.grape);
        orange = (RadioButton)findViewById(R.id.orange);
        pineapple = (RadioButton)findViewById(R.id.pineapple);

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                View v1 = View.inflate(MainActivity.this,R.layout.dialog1,null);
                dlg.setView(v1);
                image = (ImageView)v1.findViewById(R.id.image);

                switch (rdogrp.getCheckedRadioButtonId()) {
                    case R.id.apple:
                        dlg.setTitle("사과");
                        image.setImageResource(R.drawable.apple);
                        break;
                    case R.id.banana:
                        dlg.setTitle("바나나");
                        image.setImageResource(R.drawable.banana);
                        break;
                    case R.id.grape:
                        dlg.setTitle("포도");
                        image.setImageResource(R.drawable.grape);
                        break;
                    case R.id.orange:
                        dlg.setTitle("오렌지");
                        image.setImageResource(R.drawable.orange);
                        break;
                    case R.id.pineapple:
                        dlg.setTitle("파인애플");
                        image.setImageResource(R.drawable.pineapple);
                        break;
                }
                dlg.setPositiveButton("닫기",null);
                dlg.show();



            }
        });
    }
}
