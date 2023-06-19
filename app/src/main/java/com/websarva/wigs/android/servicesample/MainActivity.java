package com.websarva.wigs.android.servicesample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intentオブジェクトを取得。
        Intent intent = getIntent();
        //通知のタップからの引継ぎデータを取得。
        boolean fromNotification = intent.getBooleanExtra("fromNotification",false);
        //引継ぎデータが存在、つまり通知のタップからならば・・・
        if (fromNotification){
            //再生ボタンをタップ不可に、停止ボタンをタップ可に変更。
            Button btPlay = findViewById(R.id.btPlay);
            Button btStop = findViewById(R.id.btStop);
            btPlay.setEnabled(false);
            btStop.setEnabled(true);
        }
    }

    public void onPlayButtonClick(View view){
        //インテントオブジェクトを生成。
        Intent intent = new Intent(MainActivity.this,SoundManageService.class);
        //サービスを起動。
        startService(intent);
        //再生ボタンをタップ負荷に、停止ボタンをタップ可に変更。
        Button btPlay = findViewById(R.id.btPlay);
        Button btStop = findViewById(R.id.btStop);
        btPlay.setEnabled(false);
        btStop.setEnabled(true);
    }

    public void onStopButtonClick(View view){
        //インテントオブジェクトを生成。
        Intent intent = new Intent(MainActivity.this,SoundManageService.class);

        //サービスを停止。
        stopService(intent);

        //再生ボタンをタップ可に、停止ボタンをタップ不可に変更。
        Button btPlay = findViewById(R.id.btPlay);
        Button btStop = findViewById(R.id.btStop);
        btPlay.setEnabled(true);
        btStop.setEnabled(false);
    }
}