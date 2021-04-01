package com.example.employeesqlite;

public class Employee {

    private int employeeID;
    private String employeeName;
    private String address;
    private int age;
    private String position;

    public Employee(String name, String address, int age, String position){
        this.employeeName = name;
        this.address = address;
        this.age = age;
        this.position = position;
    }

    public Employee(int employeeID, String employeeName, String address, int age, String position) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.address = address;
        this.age = age;
        this.position = position;
    }

    public Employee(){

    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
