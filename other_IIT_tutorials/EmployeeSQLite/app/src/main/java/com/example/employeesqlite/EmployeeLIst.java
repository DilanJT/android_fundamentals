package com.example.employeesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeLIst extends AppCompatActivity {

    ListView listView;
    List<String> employeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_l_ist);

        listView = (ListView) findViewById(R.id.list_view);
        employeeList = new ArrayList<>();

        readAllEmployees();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, employeeList);
        listView.setAdapter(adapter);

    }

    public void readAllEmployees() {
        EmployeeDataHelper db = new EmployeeDataHelper(this);

        Log.d("Reading: ", "Reading all contacts..");
        List<Employee> employees = db.getAllEmployees();

        for(Employee e : employees){
            String log = "ID:" + e.getEmployeeID() + ", Name:" + e.getEmployeeName() + ", Position:" + e.getPosition();
            // logging the employee logs
            Log.d("Name: ", log);
            employeeList.add(log);
        }
    }

}