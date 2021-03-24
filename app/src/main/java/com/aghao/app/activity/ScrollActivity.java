package com.aghao.app.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.Toast;

import com.aghao.app.R;

public class ScrollActivity extends AppCompatActivity {

    private static final String TAG = "justyin";
    Scroller myScroller;
    GestureDetector myGestureDetector;
    Button btnIntercept;
    ImageView imgBoy;

    float oldX, oldY;
    float disX, disY;
    int topV, leftV, rightV, bottomV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_main);

        imgBoy = findViewById(R.id.imgboy);
        btnIntercept = findViewById(R.id.btninter);

        btnIntercept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ScrollActivity.this, ScrollConflictActivity.class);
                startActivity(intent);
            }
        });
        imgBoy.setOnTouchListener(imgOnTouchListener);
        imgBoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "View的onClick");
            }
        });
        myGestureDetector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                imgBoy.offsetLeftAndRight((int) -disX);
                imgBoy.offsetTopAndBottom((int) -disY);
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                Toast.makeText(ScrollActivity.this, "你在滑动手指", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "你在滑动手指");
                disX = distanceX;
                disY = distanceY;
                imgBoy.offsetLeftAndRight((int) -distanceX);
                imgBoy.offsetTopAndBottom((int) -distanceY);
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                return false;
            }
        });
    }

    View.OnTouchListener imgOnTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    Log.i(TAG, "View的onTouch");
                    topV = v.getTop();
                    leftV = v.getLeft();
                    rightV = v.getRight();
                    bottomV = v.getBottom();
                    break;
                case MotionEvent.ACTION_MOVE:
                    Log.i(TAG, "View的onTouch的Move");
                    break;
            }
            return myGestureDetector.onTouchEvent(event);
        }
    };

}
