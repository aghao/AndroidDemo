package com.aghao.app.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.aghao.app.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "justyin";

    Button btnViewTouch, btnScroll, btnSecond, btnCircleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnScroll = findViewById(R.id.btnScroll);
        btnViewTouch = findViewById(R.id.btnViewTouch);
        btnSecond = findViewById(R.id.btnSecond);
        btnCircleView = findViewById(R.id.btnCirlceView);

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
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        btnCircleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CustomViewActivity.class);
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
}
