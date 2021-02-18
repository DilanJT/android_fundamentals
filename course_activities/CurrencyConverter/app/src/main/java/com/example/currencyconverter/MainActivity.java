package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convertCurrency(View view) {
        EditText amount = (EditText) findViewById(R.id.editTextAmountInput);
        double amountInDollars = Double.parseDouble(amount.getText().toString());
        double amountInLankanRupees = amountInDollars * 196.55;
        String amountInRupeesString = String.format("%.2f", amountInLankanRupees);
        Toast.makeText(getApplicationContext(), "Amount in SriLankan Rupees : " + amountInRupeesString, Toast.LENGTH_SHORT).show();
    }
}