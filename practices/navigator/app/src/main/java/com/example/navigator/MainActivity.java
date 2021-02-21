package com.example.navigator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button firstButton;
    Button secondButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstButton = (Button) findViewById(R.id.firstFragBtn);
        firstButton.setOnClickListener(this);
        secondButton = (Button) findViewById(R.id.secFragBtn);
        secondButton.setOnClickListener(this);

        // this code is used to default open the first fragment when app is started
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new FirstFragment()).commit();
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.firstFragBtn:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new FirstFragment()).commit();
                break;
            case R.id.secFragBtn:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new SecondFragment()).commit();
                break;
        }
    }
}