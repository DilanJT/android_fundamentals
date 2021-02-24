package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String LOG_TAG = SecondActivity.class.getSimpleName();
    public static final String EXTRA_REPLY = "com.example.android.shoppinglist.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btn1 = (Button) findViewById(R.id.apples);
        btn1.setOnClickListener(this);
        Button btn2 = (Button) findViewById(R.id.oranges);
        btn2.setOnClickListener(this);
        Button btn3 = (Button) findViewById(R.id.cheese);
        btn3.setOnClickListener(this);
        Button btn4 = (Button) findViewById(R.id.chilli_paste);
        btn4.setOnClickListener(this);
        Button btn5 = (Button) findViewById(R.id.butter);
        btn5.setOnClickListener(this);
        Button btn6 = (Button) findViewById(R.id.oliveOil);
        btn6.setOnClickListener(this);
        Button btn7 = (Button) findViewById(R.id.rice);
        btn7.setOnClickListener(this);
        Button btn8 = (Button) findViewById(R.id.ice_cream);
        btn8.setOnClickListener(this);
        Button btn9 = (Button) findViewById(R.id.milk);
        btn9.setOnClickListener(this);
        Button btn10 = (Button) findViewById(R.id.source);
        btn10.setOnClickListener(this);
    }


    public void onItemPressed(View view) {

    }

    @Override
    public void onClick(View v) {
        String text = "NOTHING SELECTED";
        switch(v.getId()){
            case R.id.apples:
            case R.id.oranges:
            case R.id.cheese:
            case R.id.chilli_paste:
            case R.id.butter:
            case R.id.rice:
            case R.id.ice_cream:
            case R.id.milk:
            case R.id.source:
            case R.id.button2:
            case R.id.oliveOil:
                text = (String) v.getTag();
                Log.d(LOG_TAG, text);
                break;

        }

        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, text);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}