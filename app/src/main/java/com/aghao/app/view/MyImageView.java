package com.aghao.app.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

public class MyImageView extends android.support.v7.widget.AppCompatImageView {

    private int oldX, oldY;

    public MyImageView(Context context) {
        super(context);
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                performClick();
                break;
            case MotionEvent.ACTION_DOWN:
                oldX = x;
                oldY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int dx = x - oldX;
                int dy = y - oldY;
                layout(getLeft()+dx, getTop()+dy, getRight()+dx, getBottom()+dy);
                break;
        }
        return true;
    }
}
