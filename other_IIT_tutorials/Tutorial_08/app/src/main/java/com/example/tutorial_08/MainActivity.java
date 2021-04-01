package com.example.tutorial_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button displayFriends;
    Button customListView;
    Button dynamicLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayFriends = (Button) findViewById(R.id.btnFriends);
        customListView = (Button) findViewById(R.id.btn_customListViews);
        dynamicLayout = (Button) findViewById(R.id.btn_dynamicLayouts);

        displayFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DisplayFriends.class);
                startActivity(intent);
            }
        });

        customListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CustomListView.class);
                startActivity(intent);
            }
        });

        dynamicLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DynamicLayouts.class);
                startActivity(intent);
            }
        });

    }
}