package com.eking.scrolldemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.eking.scrolldemo.R;

/**
 * Created by jinzexiang on 8/22 0022.
 */
public class LayoutDemo extends View {

    int LastX,LastY;
    private Paint mPaint;

    public LayoutDemo(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.parseColor("#d3d4f3"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(0,0,600,600,mPaint);
    }


  /*  //视图坐标
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.e("x---->",x+"");
                Log.e("x---->",y+"");
                //记录触摸点坐标
                LastX = x;
                LastY = y;
                break;
            case MotionEvent.ACTION_MOVE :
                int offestX = x - LastX;

                int offestY = y - LastY;

                // 在当前left、top、right、bottom的基础上加上偏移量
                layout(getLeft()+offestX,getTop()+offestY,getRight()+offestX,getBottom()+offestY);

                break;
        }


        return true;
    }

*/
    //视图坐标
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int RawX = (int) event.getRawX();
        int RawY = (int) event.getRawY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.e("x---->",RawX+"");
                Log.e("x---->",RawY+"");
                //记录触摸点坐标
                LastX = RawX;
                LastY = RawY;
                break;
            case MotionEvent.ACTION_MOVE :
                int offestX = RawX - LastX;

                int offestY = RawY - LastY;

                // 在当前left、top、right、bottom的基础上加上偏移量
                layout(getLeft()+offestX,getTop()+offestY,getRight()+offestX,getBottom()+offestY);


                LastX = RawX;
                LastY = RawY;
                break;
        }


        return true;
    }




}

