package com.aghao.app.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

import com.aghao.app.R;
import com.aghao.app.view.MyImageView;

public class ScrollActivity extends AppCompatActivity {

    private static final String TAG = "justyin";

    TextView tvCord;
    Scroller myScroller;
    GestureDetector myGestureDetector;
    MyImageView imgBoy;

    private int oldX, oldY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_main);

        tvCord = findViewById(R.id.tvCord);
        imgBoy = findViewById(R.id.imgboy);
    }

}
