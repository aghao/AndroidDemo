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
    ImageView imgBoy, imgGirl;

    private int oldX, oldY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_main);

        tvCord = findViewById(R.id.tvCord);
        imgBoy = findViewById(R.id.imgboy);
        imgGirl = findViewById(R.id.imggirl);
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
                    oldX = (int) event.getX();
                    oldY = (int) event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    tvCord.setText("x坐标："+event.getX()+"|"+"y坐标："+event.getY());
                    int dx = (int)event.getX() - oldX;
                    int dy = (int)event.getY() - oldY;
                    // getParent方法会获得父View，但会使父View中所有View滑动
                    ((View)v.getParent()).scrollBy(-dx, -dy);
                    break;
            }
            return true;
        }
    };

}
