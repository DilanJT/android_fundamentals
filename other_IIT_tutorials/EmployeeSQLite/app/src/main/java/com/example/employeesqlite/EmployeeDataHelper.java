package com.example.employeesqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Address;

import java.util.ArrayList;
import java.util.List;

import static android.provider.BaseColumns._ID;
import static com.example.employeesqlite.Constants.ADDRESS;
import static com.example.employeesqlite.Constants.AGE;
import static com.example.employeesqlite.Constants.NAME;
import static com.example.employeesqlite.Constants.POSITION;
import static com.example.employeesqlite.Constants.TABLE_NAME;

public class EmployeeDataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "employees.db";
    private static final int DATABASE_VERSION = 1;

    //helper object for the employees database
    public EmployeeDataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ("
            + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME + " TEXT NOT NULL,"
            + ADDRESS + " TEXT,"
            + AGE + " INTEGER,"
            + POSITION + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addEmployee(Employee emp){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, emp.getEmployeeName());
        values.put(ADDRESS, emp.getAddress());
        values.put(AGE, emp.getAge());
        values.put(POSITION, emp.getPosition());

        db.insertOrThrow(TABLE_NAME, null, values);
        db.close();
    }

    // get a single employee
    public Employee getEmployee(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] {
                _ID, NAME, ADDRESS, AGE, POSITION}, _ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();

        Employee employee = new Employee(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                Integer.parseInt(cursor.getString(3)),
                cursor.getString(4));

        return employee;
    }

    // to get all the employees as a list
    public List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();

        String selectStm = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectStm, null);

        if(cursor.moveToFirst()) {
            do{
                Employee employee = new Employee();
                employee.setEmployeeID(Integer.parseInt(cursor.getString(0)));
                employee.setEmployeeName(cursor.getString(1));
                employee.setAddress(cursor.getString(2));
                employee.setAge(Integer.parseInt(cursor.getString(3)));
                employee.setPosition(cursor.getString(4));

                employees.add(employee);
            }while (cursor.moveToNext());
        }

        return employees;
    }



    // deleting single employee
    public void deleteEmployee(Employee emp){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,  _ID + " = ?",
                new String[] {String.valueOf(emp.getEmployeeID())});
        db.close();
    }

    // update contact
    public int updateEmployee(Employee employee){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, employee.getEmployeeName());
        values.put(ADDRESS, employee.getAddress());
        values.put(AGE, employee.getAge());
        values.put(POSITION, employee.getPosition());

        // updating the specific row
        return db.update(TABLE_NAME, values, _ID + " = ?",
                new String[] {String.valueOf(employee.getEmployeeID())});
    }

}
