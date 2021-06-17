package com.aghao.app.activity;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.aghao.app.R;
import com.aghao.app.receiver.MyBroadcastReceiver;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "justyin";

    Button btnViewTouch, btnScroll, btnSecond, btnCircleView, btnShowImg;
    MyBroadcastReceiver myBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "MainActivity - onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnScroll = findViewById(R.id.btnScroll);
        btnViewTouch = findViewById(R.id.btnViewTouch);
        btnSecond = findViewById(R.id.btnSecond);
        btnCircleView = findViewById(R.id.btnCirlceView);
        btnShowImg = findViewById(R.id.btnShowImg);

        //已有权限
        if (ContextCompat.checkSelfPermission(this,  Manifest.permission.PROCESS_OUTGOING_CALLS) == PackageManager.PERMISSION_GRANTED) {
        } else {
            //申请权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.PROCESS_OUTGOING_CALLS}, 1);
        }
        // 广播接收者动态注册
        myBroadcastReceiver = new MyBroadcastReceiver();
        String action = Intent.ACTION_NEW_OUTGOING_CALL;
        String action1 = "AGHAO";
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(action);
        intentFilter.addAction(action1);
        intentFilter.setPriority(1000);
        registerReceiver(myBroadcastReceiver, intentFilter);

        btnScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScrollActivity.class);
                startActivity(intent);
            }
        });

        btnViewTouch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewTouchActivity.class);
                startActivity(intent);
            }
        });

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                startActivity(intent);
                Intent intent = new Intent();
                intent.setAction("AGHAO");
                // 用于本APP接收
                intent.setClassName(getPackageName(), getPackageName()+".receiver.MyBroadcastReceiver");
                // 用于其他APP接收
//                intent.setComponent(new ComponentName(getPackageName(),
//                        getPackageName() + ".receiver.MyBroadcastReceiver"));
                sendBroadcast(intent);
            }
        });

        btnCircleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CustomViewActivity.class);
                startActivity(intent);
            }
        });

        btnShowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowImageActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, "MainActivity - onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "MainActivity - onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "MainActivity - onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "MainActivity - onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "MainActivity - onDestroy");
        super.onDestroy();
        // 取消动态广播注册
        if(myBroadcastReceiver != null) {
            unregisterReceiver(myBroadcastReceiver);
        }
    }
}
