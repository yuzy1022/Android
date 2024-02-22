package com.cookandroid.a2018021097;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.Display;
import android.view.WindowManager;
import android.view.Gravity;

public class MainActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("2018021097 박상원");
        btn = (Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast imgtst = new Toast(getApplicationContext());
                ImageView img = new ImageView(getApplicationContext());
                img.setImageResource(R.drawable.cat);
                imgtst.setView(img);
                Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                int xOffset = (int) (Math.random()*display.getWidth());
                int yOffset = (int) (Math.random()*display.getHeight());
                imgtst.setGravity(Gravity.TOP|Gravity.LEFT,xOffset,yOffset);
                imgtst.show();
            }
        });
    }
}


