package org.kainos.ea.cli;

public class Employee {

    private int employeeId;
    private String fName;
    private String lName;
    private double salary;
    private String bankAccNum;
    private String niNum;

    public Employee(int employeeId, String fName, String lName, double salary, String bankAccNum, String niNum) {
        this.employeeId = employeeId;
        this.fName = fName;
        this.lName = lName;
        this.salary = salary;
        this.bankAccNum = bankAccNum;
        this.niNum = niNum;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBankAccNum() {
        return bankAccNum;
    }

    public void setBankAccNum(String bankAccNum) {
        this.bankAccNum = bankAccNum;
    }

    public String getNiNum() {
        return niNum;
    }

    public void setNiNum(String niNum) {
        this.niNum = niNum;
    }
}
