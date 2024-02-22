package com.example.ex_11_4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editItem = findViewById(R.id.edtItem);
        Button btnAdd = findViewById(R.id.btnAdd);
        ListView list = findViewById(R.id.listView1);

        final ArrayList<String> midList = new ArrayList<String>();

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, midList);
        list.setAdapter(adapter);

        //항목추가 버튼 클릭했을 때
        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                midList.add(editItem.getText().toString());  //midList 배열에 입력된 String 추가
                adapter.notifyDataSetChanged();  //리스트 업데이트
            }
        });

        //리스트 항목 롱클릭 했을 때
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            
            public boolean onItemLongClick (AdapterView < ? > parent, View view, int position, long id){
                
                //대화상자 객체 생성
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("삭제");
                dlg.setMessage("삭제하시겠습니까?");
                
                //대화상자에 삭제와 취소버튼 추가
                dlg.setPositiveButton("삭제", new DialogInterface.OnClickListener() { //삭제버튼 눌렀을 때
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        midList.remove(position); //midList 배열에서 해당 항목 삭제
                        adapter.notifyDataSetChanged();  //리스트 업데이트
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show(); //대화상자 띄우기

                return false;
            }
        });
    }
}