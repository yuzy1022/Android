package com.example.project13_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listV;
    Button btnPlay, btnStop;
    TextView tVTitle, tvTime;
    ProgressBar pbPlay;

    ArrayList<String> mp3List;
    String selectedMP3;

    String mp3Path = Environment.getExternalStorageDirectory().getPath() + "/Music/";

    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 mp3플레이어");

        btnPlay = findViewById(R.id.btnPlay);
        btnStop = findViewById(R.id.btnStop);
        tVTitle = findViewById(R.id.tvTitle);
        tvTime = findViewById(R.id.tvTime);
        pbPlay = findViewById(R.id.pbPlay);

        ActivityCompat.requestPermissions(this, new String[]
                {android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        mp3List = new ArrayList<>();

        File[] listFiles = new File(mp3Path).listFiles();
        String fileName, extName;
        for (File file : listFiles)
        {
            fileName = file.getName();
            extName = fileName.substring(fileName.length() - 3);
            if(extName.equals((String) "mp3")) mp3List.add(fileName);
        }

        listV = findViewById(R.id.listV);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, mp3List);
        listV.setAdapter(adapter);
        listV.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listV.setItemChecked(0, true);

        listV.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedMP3 = mp3List.get(position);
            }
        });
        selectedMP3 = mp3List.get(0);

        btnPlay.setOnClickListener((v) ->{
            try
            {
                mPlayer = new MediaPlayer();
                mPlayer.setDataSource(mp3Path + selectedMP3);
                mPlayer.prepare();
                mPlayer.start();
                btnPlay.setClickable(false);
                btnStop.setClickable(true);
                tVTitle.setText("실행 중인 음악 : " + selectedMP3);

                new Thread()
                {
                    SimpleDateFormat timeFormat = new SimpleDateFormat("mm:ss");
                    public void run()
                    {
                        if(mPlayer == null) return;
                        pbPlay.setMax(mPlayer.getDuration());
                        while(mPlayer.isPlaying())
                        {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    pbPlay.setProgress(mPlayer.getCurrentPosition());
                                    tvTime.setText("진행 시간 : " + timeFormat.format(mPlayer.getCurrentPosition()) );
                                }
                            });
                            SystemClock.sleep(1000);
                        }
                    }
                }.start();
            }
            catch (IOException e) {}
        });

        btnStop.setOnClickListener((v)->{
            mPlayer.stop();
            mPlayer.reset();
            btnPlay.setClickable(true);
            btnStop.setClickable(false);
            tVTitle.setText("실행 중인 음악 : ");
            tvTime.setText("진행 시간 : ");
            pbPlay.setProgress(0);
        });
        btnStop.setClickable(false);
    }
}