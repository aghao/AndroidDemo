package com.aghao.app.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.aghao.app.R;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "justyin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, "SecondActivity - onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "SecondActivity - onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "SecondActivity - onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "SecondActivity - onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "SecondActivity - onDestroy");
        super.onDestroy();
    }
}
