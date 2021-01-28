package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
    }

    public void showToast(View view) {
        //Here we have to supply the context of the app activity
        //therefore, as we already within the context of the Activity, we can use "this" keyword.
        //first arg -> this
        //second arg -> value used to display by getting from the R file
        //third arg -> display duration time.
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        //Toast.LENGTH_SHORT -> 2 seconds
        //Toast.LENGTH_LONG -> 3.5 seconds
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if(mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
}