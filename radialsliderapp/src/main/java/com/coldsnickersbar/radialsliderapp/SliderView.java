package com.coldsnickersbar.radialsliderapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Adam on 11/22/15.
 */
public class SliderView extends View {

    private final SliderDrawable mSliderDrawable;
    private OnCoordsChangedListener mCoordsChangedListener;

    public SliderView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mSliderDrawable = new SliderDrawable();
        setBackgroundDrawable(mSliderDrawable);

        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.SliderView);

            float center_x = a.getFloat(R.styleable.SliderView_center_x, 0f);
            float center_y = a.getFloat(R.styleable.SliderView_center_y, 0f);
            mSliderDrawable.setCenter(center_x, center_y);
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event){
        int action = event.getActionMasked();

        if (isCoordsChange(action)){
            float x = event.getX();
            float y = event.getY();
            if (mCoordsChangedListener != null) {
                mCoordsChangedListener.onCoordsChanged(x, y);
            }

            mSliderDrawable.setCoords(x, y);
        }
        return true;
    }

    private boolean isCoordsChange(int action) {
        return action == MotionEvent.ACTION_MOVE || action == MotionEvent.ACTION_DOWN;
    }

    public void setOnCoordsChangedListener(OnCoordsChangedListener listener){
        mCoordsChangedListener = listener;
    }

    public interface OnCoordsChangedListener {

        void onCoordsChanged(float x, float y);
    }
}
