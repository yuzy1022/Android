package com.example.ex_11_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public Integer [] posterID = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gv = findViewById(R.id.gridView1);

        MygridAdapter gAdapter = new MygridAdapter(this);
        gv.setAdapter(gAdapter);
    }

    /*public class MyGridAdapter extends BaseAdapter{
        Context context;

        public MyGridAdapter(Context _context) {
            context = _context;
        } //MainActivity를 받아와서 context에 넣음

        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) { //convertView = ViewHolder, parent = 그리드뷰
            ImageView ivG = new ImageView(context);
            ivG.setLayoutParams(new ViewGroup.LayoutParams(250, 300));
            ivG.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ivG.setPadding(5, 5,5 ,5);

            ivG.setImageResource(posterID[position]);

            final int pos = position;
            ivG.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);  //대화상자 객체 생성
                    View dlgView = (View) View.inflate(MainActivity.this, R.layout.dialog, null); //대화상자에 적용할 xml파일을 불러옴
                    dlg.setView(dlgView); //대화상자에 xml 적용
                    ImageView imgView = (ImageView) dlgView.findViewById(R.id.ivPoster); //대화상자 안에 있는 이미지뷰를 불러옴
                    imgView.setImageResource(posterID[pos]); //이미지뷰의 이미지 설정

                    dlg.setTitle("영화 포스터");
                    dlg.setIcon(R.mipmap.ic_launcher);
                    dlg.setView(dlgView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });

            return ivG;
        }
    }*/
}