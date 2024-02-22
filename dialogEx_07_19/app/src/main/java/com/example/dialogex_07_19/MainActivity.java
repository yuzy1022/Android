package com.example.dialogex_07_19;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        final String[] versionArray = new String[] {"젤리빈", "킷캣", "롤리팝"};
        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

        dlg.setTitle("사용하는 버전은?");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
    }
}