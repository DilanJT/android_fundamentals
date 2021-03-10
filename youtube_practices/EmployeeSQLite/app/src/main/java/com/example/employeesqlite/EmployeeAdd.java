package com.example.employeesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.employeesqlite.Constants.ADDRESS;
import static com.example.employeesqlite.Constants.AGE;
import static com.example.employeesqlite.Constants.NAME;
import static com.example.employeesqlite.Constants.POSITION;
import static com.example.employeesqlite.Constants.TABLE_NAME;

public class EmployeeAdd extends AppCompatActivity {

    private EmployeeDataHelper db;
    EditText empName;
    EditText empAge;
    EditText empAddress;
    EditText empPosition;
    Button btnAddEmp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_add);

        db = new EmployeeDataHelper(this);
        empName = (EditText) findViewById(R.id.empName);
        empAddress = (EditText) findViewById(R.id.empAdress);
        empAge = (EditText) findViewById(R.id.empAge);
        empPosition = (EditText) findViewById(R.id.empPosition);
        btnAddEmp = (Button) findViewById(R.id.add_employee);

        btnAddEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(empName.getText().toString().isEmpty()){
                    Toast.makeText(EmployeeAdd.this, "Don't keep the name null", Toast.LENGTH_SHORT).show();
                }else{
                    db.addEmployee(new Employee(
                            empName.getText().toString(),
                            empPosition.getText().toString(),
                            Integer.parseInt(empAge.getText().toString()),
                            empAddress.getText().toString()));

                    Log.d("Inserting :", "Name : " + empName.getText().toString());
                }

                empName.setText(null);
                empAddress.setText(null);
                empAge.setText(null);
                empPosition.setText(null);

            }
        });

    }


}