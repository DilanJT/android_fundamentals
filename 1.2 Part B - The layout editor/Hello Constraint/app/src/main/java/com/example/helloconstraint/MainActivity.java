package com.example.helloconstraint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.ShowCount);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void resetCount(View view) {
        count = 0;
        if(mShowCount != null) {
            mShowCount.setText(Integer.toString(count));
        }
    }

    public void countUp(View view) {
        count++;
        if(mShowCount != null) {
            mShowCount.setText(Integer.toString(count));
        }
    }

    public void countDown(View view) {
        count--;
        if(mShowCount != null) {
            mShowCount.setText(Integer.toString(count));
        }
    }
}