package com.example.ex_11_1;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MygridAdapter extends BaseAdapter {
        Context context;
        Integer[] posterID;

        public MygridAdapter(Context _context) {
            context = _context;
            posterID = ((MainActivity)context).posterID;
        }


        public int getCount() {
            return posterID.length;
        }


        public Object getItem(int i) {
            return null;
        }


        public long getItemId(int i) {
            return 0;
        }


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
                    /*AlertDialog.Builder dlg = new AlertDialog.Builder(context);  //대화상자 객체 생성
                    View dlgView = (View) View.inflate(context, R.layout.dialog, null); //대화상자에 적용할 xml파일을 불러옴
                    dlg.setView(dlgView); //대화상자에 xml 적용
                    ImageView imgView = (ImageView) dlgView.findViewById(R.id.ivPoster); //대화상자 안에 있는 이미지뷰를 불러옴
                    imgView.setImageResource(posterID[pos]); //이미지뷰의 이미지 설정

                    dlg.setTitle("영화 포스터");
                    dlg.setIcon(R.mipmap.ic_launcher);
                    dlg.setView(dlgView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();*/

                    Intent intent = new Intent(context, secondActivity.class);
                    intent.putExtra("pos", pos);
                    context.startActivity(intent);
                }
            });

            return ivG;
        }
}
