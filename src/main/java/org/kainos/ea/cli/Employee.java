package org.kainos.ea.cli;



public class Employee {

    private int employee_id;
    private String f_Name;
    private String l_Name;
    private double salary;
    private String bank_acc_num;
    private String ni_num;

    public Employee(int employee_id, String f_name, String l_name, double salary, String bank_acc_num, String ni_num) {
        this.employee_id = employee_id;
        this.f_Name = f_name;
        this.l_Name = l_name;
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

    public String getF_Name() {
        return f_Name;
    }

    public void setF_Name(String f_Name) {
        this.f_Name = f_Name;
    }

    public String getL_Name() {
        return l_Name;
    }

    public void setL_Name(String l_Name) {
        this.l_Name = l_Name;
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
