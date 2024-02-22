package com.example.httpbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    NetworkImageView imgV;
    RequestQueue queue;
    TextView tvId, tvName, tvAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvId = findViewById(R.id.tvId);
        tvName = findViewById(R.id.tvName);
        tvAge = findViewById(R.id.tvAge);

        imgV = findViewById(R.id.imgV);

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET,
                "http://101.101.211.66:8080/2018021097/test.json", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvId.setText(response.getString("id"));
                            tvName.setText(response.getString("name"));
                            tvAge.setText(String.valueOf(response.getInt("age")));

                            String imgFile = response.getString("file");

                            if (imgFile != null && !imgFile.equals("")) {
                                ImageLoader imageLoader = new ImageLoader(queue, new ImageLoader.ImageCache() {
                                    @Override
                                    public Bitmap getBitmap(String url) {
                                        return null;
                                    }

                                    @Override
                                    public void putBitmap(String url, Bitmap bitmap) {
                                    }
                                });

                                imgV.setImageUrl("http://101.101.211.66:8080/2018021097/" + imgFile, imageLoader);
                            }
                        } catch (Exception e) {
                            Log.d("test", e.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.d("test", error.toString());
            }
        });


        RetrofitAladin retrofitAladin = RetrofitAladin.getInstance();
        HttpRequest httpRequest_aladin = retrofitAladin.getRetrofitInterface();

        httpRequest_aladin.getSearchBook("ttbjhp22121729001", "카네기", "Book", "js", "20131101").enqueue(new Callback<DataClass>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<DataClass> call, retrofit2.Response<DataClass> response)
            {
                DataClass data = response.body();

                Log.e("태그", "onResponse: " + response.body());
                Log.e("태그", "결과 개수 : " + data.getItem().length + "\n9번째 인덱스 : " + data.getItem()[9]);


            }

            @Override
            public void onFailure(Call<DataClass> call, Throwable t)
            {
                Log.e("태그", "onFailure: " + t.getMessage());
            }
        });


        queue = Volley.newRequestQueue(this);
        queue.add(jsonRequest);
    }


}