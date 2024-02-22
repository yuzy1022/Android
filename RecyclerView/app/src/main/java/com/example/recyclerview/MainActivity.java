package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        adapter = new Adapter();
        for(int i = 0; i < 10; i++)
        {
            adapter.setArrayData(R.drawable.img_1);
        }
        recyclerView.setAdapter(adapter);
    }
}

//메인화면 리사이클러 뷰의 뷰홀더 클래스
class ViewHolder extends RecyclerView.ViewHolder
{
    public ImageView imageView;

    ViewHolder(Context context, View itemView)
    {
        super(itemView);

        imageView = itemView.findViewById(R.id.mainBookImgView);
    }
}

//메인화면 리사이클러 뷰의 어댑터 클래스
class Adapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<Integer> arrayList;

    public Adapter() {
        arrayList = new ArrayList<>();
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.book_item_main, parent, false);
        ViewHolder viewHolder = new ViewHolder(context, view);

        return viewHolder;
    }

    //앞에 있던 객체가 스크롤되어 안보이게 되면 그 객체를 뒤로 불러와 데이터를 재설정해주는 메소드
    public void onBindViewHolder(ViewHolder holder, int position) {
        int src = arrayList.get(position); //리스트에서 이미지 뷰에 설정할 이미지의 소스를 가져옴
        holder.imageView.setImageResource(src);  //이미지 뷰의 소스 설정
    }

    public int getItemCount() {
        return arrayList.size();
    }


    public void setArrayData(int srcData) {
        arrayList.add(srcData);
    }
}