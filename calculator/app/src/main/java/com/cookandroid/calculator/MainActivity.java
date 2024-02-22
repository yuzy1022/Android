package com.cookandroid.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText Edit1, Edit2;
    Button button1, button2, button3, button4, button5;
    TextView TextResult;
    String num1, num2;
    Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        Edit1 = (EditText) findViewById(R.id.Edit1);
        Edit2 = (EditText) findViewById(R.id.Edit2);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        TextResult = (TextView) findViewById(R.id.TextResult);

        button1.setOnTouchListener(new View.OnTouchListener(){
                    public boolean onTouch(View arg0, MotionEvent arg1){
                        num1 = Edit1.getText().toString();
                        num2 = Edit2.getText().toString();
                        result = Double.parseDouble(num1)+Double.parseDouble(num2);
                        TextResult.setText("계산 결과 : " + result.toString());
                        return false;
            }
        });

        button2.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1){
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                result = Double.parseDouble(num1)-Double.parseDouble(num2);
                TextResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        button3.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1){
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                result = Double.parseDouble(num1)*Double.parseDouble(num2);
                TextResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        button4.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1){
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                result = Double.parseDouble(num1)/Double.parseDouble(num2);
                TextResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        button5.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1){
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                result = Double.parseDouble(num1)%Double.parseDouble(num2);
                TextResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });


    }
}
