package com.coldsnickersbar.radialsliderapp;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/**
 * Created by Adam on 11/22/15.
 */
public class SliderDrawable extends Drawable {

    private float mX;
    private float mY;
    private PointF mCenter;
    private int mAlpha;

    @Override
    public void draw(Canvas canvas) {

        Paint paint = new Paint();

        paint.setColor(0xff333333);

        Rect bounds = getBounds();
        float width = (bounds.width() * mCenter.x) * 2;
        float height = (bounds.height() * mCenter.y) * 2;
        if (width < height){
            width = height;
        }else{
            height = width;
        }

        RectF oval = new RectF();


        canvas.drawRect(getBounds(), paint);
    }

    @Override
    public void setAlpha(int alpha) {
        mAlpha = alpha;
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    public void setCoords(float x, float y) {
        mX = x;
        mY = y;
    }

    /***
     * Sets the center, as a normalized position: 0f, 0f is bottom left and 1f, 1f is top right.
     * @param center_x
     * @param center_y
     */
    public void setCenter(float center_x, float center_y) {
        mCenter = new PointF(center_x, center_y);
    }
}
