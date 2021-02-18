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
}