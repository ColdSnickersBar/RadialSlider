package com.coldsnickersbar.radialslider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.coldsnickersbar.radialsliderapp.SliderView;

import org.w3c.dom.Text;

public class SliderMain extends AppCompatActivity {

    private TextView mCoordsReadout;
    private SliderView mSliderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_main);

        mCoordsReadout = (TextView)findViewById(R.id.coords_readout_textview);
        mSliderView = (SliderView)findViewById(R.id.slider_view);

        mSliderView.setOnCoordsChangedListener(new SliderView.OnCoordsChangedListener() {
            @Override
            public void onCoordsChanged(float x, float y) {
                mCoordsReadout.setText(String.format("x: %1$s, y: %2$s", x, y));
            }
        });
    }
}
