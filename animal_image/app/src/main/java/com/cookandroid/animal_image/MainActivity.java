package com.cookandroid.animal_image;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView Text1, Text2;
    CheckBox checkBox;
    RadioGroup Rgroup1;
    RadioButton Rdog, Rcat, Rbird;
    Button button;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진보기");

        Text1 = (TextView) findViewById(R.id.Text1);
        Text2 = (TextView) findViewById(R.id.Text2);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        Rgroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        Rdog = (RadioButton) findViewById(R.id.Rdog);
        Rcat = (RadioButton) findViewById(R.id.Rcat);
        Rbird = (RadioButton) findViewById(R.id.Rbird);
        button = (Button) findViewById(R.id.button);
        image = (ImageView) findViewById(R.id.image);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox.isChecked()==true){
                    Text2.setVisibility(View.VISIBLE);
                    Rgroup1.setVisibility(View.VISIBLE);
                    button.setVisibility(View.VISIBLE);
                    image.setVisibility(View.VISIBLE);
                } else
                {
                    Text2.setVisibility(View.INVISIBLE);
                    Rgroup1.setVisibility(View.INVISIBLE);
                    button.setVisibility(View.INVISIBLE);
                    image.setVisibility(View.INVISIBLE);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                switch (Rgroup1.getCheckedRadioButtonId()){
                    case R.id.Rdog:
                        image.setImageResource(R.drawable.dog);
                        break;
                    case R.id.Rcat:
                        image.setImageResource(R.drawable.cat);
                        break;
                    case R.id.Rbird:
                        image.setImageResource(R.drawable.bird);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물 먼저 선택하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
