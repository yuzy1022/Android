package com.example.mydbtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import javax.xml.validation.Validator;

public class MainActivity extends AppCompatActivity {
    String userID;
    EditText etId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId = findViewById(R.id.etId);
        Button btnValidate = findViewById(R.id.btnValidate);

        btnValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                userID = etId.getText().toString();
                Response.Listener rListener = new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        try
                        {
                            JSONObject jResponse = new JSONObject(response);
                            boolean newID = jResponse.getBoolean("newID");

                            if(newID)
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                AlertDialog dialog = builder.setMessage("사용할 수 있는 아이디입니다.")
                                        .setNegativeButton("확인", null).create();
                                dialog.show();
                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                AlertDialog dialog = builder.setMessage("사용할 수 없는 아이디입니다.")
                                        .setNegativeButton("확인", null).create();
                                dialog.show();
                            }
                        }
                        catch(Exception e)
                        {
                            Log.d("mytest", e.toString());
                        }
                    }
                };
                ValidateRequest vRequest = new ValidateRequest(userID, rListener);
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(vRequest);
            }
        });
    }
}