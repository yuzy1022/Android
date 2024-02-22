package com.cookandroid.a2018021097;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    ImageView ImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("2018021097 박상원");
        ImageView = (ImageView) findViewById(R.id.ImageView);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0,"사과");
        menu.add(0, 2, 0,"바나나");
        menu.add(0, 3, 0,"포도");
        menu.add(0, 4, 0,"오렌지");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                ImageView.setImageResource(R.drawable.apple);
                return true;
            case 2:
                ImageView.setImageResource(R.drawable.banana);
                return true;
            case 3:
                ImageView.setImageResource(R.drawable.grape);
                return true;
            case 4:
                ImageView.setImageResource(R.drawable.orange);
                return true;
        }
        return false;
    }

}
