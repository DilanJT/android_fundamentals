package com.example.employeesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class EmployeeView extends AppCompatActivity {

    EditText empName;
    EditText empAddress;
    EditText empAge;
    EditText empPosition;
    EditText empID;

    Button btnModify;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_view);

        empName = (EditText) findViewById(R.id.name_view);
        empAddress = (EditText) findViewById(R.id.address_view);
        empAge = (EditText) findViewById(R.id.age_view);
        empPosition = (EditText) findViewById(R.id.position_view);
        empID = (EditText) findViewById(R.id.id_view);

        btnModify = (Button) findViewById(R.id.btn_modify_view);
        btnDelete = (Button) findViewById(R.id.btn_delete_view);

        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(empID.getText().toString());
                String name = empName.getText().toString();
                String address = empAddress.getText().toString();
                String position = empPosition.getText().toString();
                int age = Integer.parseInt(empAge.getText().toString());

                Employee employee = new Employee(id, name, address, age, position);
                update(employee);
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(empID.getText().toString());
                delete(id);
                finish();
            }
        });

    }

    public void delete(int id){
        EmployeeDataHelper db = new EmployeeDataHelper(this);

        Log.d("Deleting: ", "Deleting employee..");
        List<Employee> employees = db.getAllEmployees();

        boolean found = false;

        for(Employee e : employees){
            if(e.getEmployeeID() == id){
                db.deleteEmployee(e);
                found = true;
                Toast.makeText(this, "Employee with ID:" + Integer.toString(id) + " deleted", Toast.LENGTH_SHORT).show();
            }
        }

        if(!found)
            Toast.makeText(this, "Employee with ID:" + Integer.toString(id) + " does't exist", Toast.LENGTH_SHORT).show();
    }

    public void update(Employee emp){
        EmployeeDataHelper db = new EmployeeDataHelper(this);

        List<Employee> employees = db.getAllEmployees();

        boolean found = false;

        for(Employee e : employees) {
            if(e.getEmployeeID() == emp.getEmployeeID()){
                db.updateEmployee(emp);
                found = true;
                Toast.makeText(this, "Employee with ID:" + Integer.toString(e.getEmployeeID()) + " updated", Toast.LENGTH_SHORT).show();
            }
        }

        if(!found)
            Toast.makeText(this, "Employee with ID:" + Integer.toString(emp.getEmployeeID()) + " does't exist", Toast.LENGTH_SHORT).show();
    }




}