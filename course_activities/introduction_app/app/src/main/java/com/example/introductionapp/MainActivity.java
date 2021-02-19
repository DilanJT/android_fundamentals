package com.example.introductionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean next = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView mw = (ImageView) findViewById(R.id.imageView3);
        mw.setX(-2000);
        mw.animate().translationXBy(2000).setDuration(2000);
        mw.animate().alpha(0).setDuration(2000);
    }

    public void switchCat(View view) {
        Log.i( "Info", "Button pressed");
        ImageView catView = (ImageView) findViewById(R.id.catImageViewer);

        if(next == true) {
            catView.setImageResource(R.drawable.cat1);
            next = false;
        }else {
            catView.setImageResource(R.drawable.cats2);
            next = true;
        }
    }

    public void fadeToOther(View view) {
//        switching image views with an animation
        ImageView catView = (ImageView) findViewById(R.id.catImageViewer);
        ImageView moneyView = (ImageView) findViewById(R.id.imageView2);

        if(next == true) {
            moneyView.animate().alpha(1).setDuration(500);
            catView.animate().alpha(0).setDuration(500);
            next = false;
        }else {

            moneyView.animate().alpha(0).setDuration(500);
            catView.animate().alpha(1).setDuration(500);
            next = true;
        }
    }
}