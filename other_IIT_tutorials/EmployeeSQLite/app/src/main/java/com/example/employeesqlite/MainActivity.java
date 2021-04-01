package com.example.employeesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button addEmp;
    Button showEmps;
    Button btnModifyDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addEmp = (Button) findViewById(R.id.add_emp_main);
        showEmps = (Button) findViewById(R.id.btn_show_Emps_main);
        btnModifyDelete = (Button) findViewById(R.id.btn_modify_delete);

        addEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EmployeeAdd.class);
                startActivity(intent);
            }
        });

        showEmps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EmployeeLIst.class);
                startActivity(intent);
            }
        });

        btnModifyDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EmployeeView.class);
                startActivity(intent);
            }
        });
    }
}