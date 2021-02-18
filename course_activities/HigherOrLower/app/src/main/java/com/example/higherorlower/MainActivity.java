package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int myNumber;

    public void generateRandomNum() {
        Random randomNum = new Random();
        myNumber = randomNum.nextInt(20) + 1;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandomNum();
    }

    public void onGuessPressed(View view) {


        System.out.println(myNumber);

        EditText amountEntered = (EditText) findViewById(R.id.edit_text_amount);
        int amount = Integer.parseInt(amountEntered.getText().toString());
        if(amount > 20){
            Toast.makeText(this, "Out of range!", Toast.LENGTH_SHORT).show();
        }else if(amount < 1) {
            Toast.makeText(this, "Number you entered must in between 1 - 20", Toast.LENGTH_SHORT).show();
        }else if(amount <= 20 && amount > myNumber) {
            Toast.makeText(this, "Lower", Toast.LENGTH_SHORT).show();
        }else if(amount >= 1 && amount < myNumber) {
            Toast.makeText(this, "Higher", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            generateRandomNum();
        }
    }
}