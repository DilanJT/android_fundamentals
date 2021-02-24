package com.example.shoppinglist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final int TEXT_REQUEST = 1;

    private TextView textCheese;
    private TextView textChilli;
    private TextView textRice;
    private TextView textApple;
    private TextView textOranges;
    private TextView textButter;
    private TextView textSource;
    private TextView textOlive;
    private TextView textCream;
    private TextView textMilk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textCheese = findViewById(R.id.textView1);
        textChilli = findViewById(R.id.textView2);
        textRice = findViewById(R.id.textView3);
        textApple = findViewById(R.id.textView4);
        textOranges = findViewById(R.id.textView5);
        textButter = findViewById(R.id.textView6);
        textSource = findViewById(R.id.textView7);
        textOlive = findViewById(R.id.textView8);
        textCream = findViewById(R.id.textView9);
        textMilk = findViewById(R.id.textView10);


        if(savedInstanceState != null) {
            textCheese.setText(savedInstanceState.getString("1"));
            textChilli.setText(savedInstanceState.getString("2"));
            textRice.setText(savedInstanceState.getString("3"));
            textApple.setText(savedInstanceState.getString("4"));
            textOranges.setText(savedInstanceState.getString("5"));
            textButter.setText(savedInstanceState.getString("6"));
            textSource.setText(savedInstanceState.getString("7"));
            textOlive.setText(savedInstanceState.getString("8"));
            textCream.setText(savedInstanceState.getString("9"));
            textMilk.setText(savedInstanceState.getString("10"));
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putString("1", textCheese.getText().toString());
        outState.putString("2", textChilli.getText().toString());
        outState.putString("3", textRice.getText().toString());
        outState.putString("4", textApple.getText().toString());
        outState.putString("5", textOranges.getText().toString());
        outState.putString("6", textButter.getText().toString());
        outState.putString("7", textSource.getText().toString());
        outState.putString("8", textOlive.getText().toString());
        outState.putString("9", textCream.getText().toString());
        outState.putString("10", textMilk.getText().toString());
    }

    public void btnOnAddItem(View view) {
        Log.d(LOG_TAG, "Add an item button clicked");

        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == TEXT_REQUEST) {
            if(resultCode == RESULT_OK) {
                if(data != null) {
                    String item = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                    switch(item){
                        case "cheese":
                            textCheese.setText(item);
                            break;
                        case "chilli paste":
                            textChilli.setText(item);
                            break;
                        case "rice":
                            textRice.setText(item);
                            break;
                        case "apples":
                            textApple.setText(item);
                            break;
                        case "oranges":
                            textOranges.setText(item);
                            break;
                        case "butter":
                            textButter.setText(item);
                            break;
                        case "source":
                            textSource.setText(item);
                            break;
                        case "olive oil":
                            textOlive.setText(item);
                            break;
                        case "ice cream":
                            textCream.setText(item);
                            break;
                        case "milk":
                            textMilk.setText(item);
                            break;
                    }
                }
            }
        }
    }
}