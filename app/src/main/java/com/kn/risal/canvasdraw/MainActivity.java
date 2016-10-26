package com.kn.risal.canvasdraw;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CalendarView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.kn.risal.canvasdraw.DrawView.ActivityColoringPage;

import java.util.LinkedList;
import java.util.Queue;

public class MainActivity extends ActivityColoringPage{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        setContentView(R.layout.activity_main);
        ((ImageView) findViewById(R.id.iv_coloring_figure)).setImageResource(R.drawable.tortoise);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        logEvent(EVENT_COLOR_TORTOISE);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        setContentView(R.layout.activity_main);
        ((ImageView) findViewById(R.id.iv_coloring_figure)).setImageResource(R.drawable.tortoise);
        super.onConfigurationChanged(newConfig);
    }
}
