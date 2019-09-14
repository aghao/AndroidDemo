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

public class ScrollActivity extends AppCompatActivity {

    private static final String TAG = "justyin";

    TextView tvCord;
    Scroller myScroller;
    GestureDetector myGestureDetector;
    ImageView imgBoy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_main);

        tvCord = findViewById(R.id.tvCord);
        imgBoy = findViewById(R.id.imgboy);
        imgBoy.setOnTouchListener(imgOnTouchListener);
    }

    View.OnTouchListener imgOnTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_UP:
                    v.performClick();
                    break;
                case MotionEvent.ACTION_DOWN:
                    Log.i(TAG, "ACTION_DOWN");
                    break;
                case MotionEvent.ACTION_MOVE:
                    tvCord.setText("x坐标："+event.getX()+"|"+"y坐标："+event.getY());
                    break;
            }
            return true;
        }
    };

}
