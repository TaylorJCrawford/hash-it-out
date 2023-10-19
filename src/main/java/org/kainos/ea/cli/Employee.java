package org.kainos.ea.cli;

public class Employee {

    private int employee_id;
    private String fName;
    private String lName;
    private double salary;
    private String bank_acc_num;
    private String ni_num;

    public Employee(int employee_id, String fname, String lname, double salary, String bank_acc_num, String ni_num) {
        this.employee_id = employee_id;
        this.fName = fname;
        this.lName = lname;
        this.salary = salary;
        this.bank_acc_num = bank_acc_num;
        this.ni_num = ni_num;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
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

    public String getBank_acc_num() {
        return bank_acc_num;
    }

    public void setBank_acc_num(String bank_acc_num) {
        this.bank_acc_num = bank_acc_num;
    }

    public String getNi_num() {
        return ni_num;
    }

    public void setNi_num(String ni_num) {
        this.ni_num = ni_num;
    }
}
