package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;
    Button btAdd, btSub, btMul, btDiv;
    TextView resultText;
    String num1, num2;
    Long result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        //값을 입력받을 EditTExt
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);

        //더하기, 빼기, 곱하기, 나누기 버튼
        btAdd = (Button) findViewById(R.id.btAdd);
        btSub = (Button) findViewById(R.id.btSub);
        btMul = (Button) findViewById(R.id.btMul);
        btDiv = (Button) findViewById(R.id.btDiv);

        //결과 값 표시할 TextView
        resultText = (TextView) findViewById(R.id.resultText);

        //더하기 버튼 누르면
        btAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //입력창 1, 2에서 값을 string으로 받아와 num1, num2에 저장
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();
                result = Long.parseLong(num1) + Long.parseLong(num2);
                resultText.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btSub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();
                result = Long.parseLong(num1) - Long.parseLong(num2);
                resultText.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();
                result = Long.parseLong(num1) * Long.parseLong(num2);
                resultText.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btDiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();
                result = Long.parseLong(num1) / Long.parseLong(num2);
                resultText.setText("계산 결과 : " + result.toString());
                return false;
            }
        });
    }
}