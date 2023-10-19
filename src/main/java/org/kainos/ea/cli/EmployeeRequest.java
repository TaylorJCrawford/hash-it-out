package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeRequest {
    private String fName;
    private String lName;
    private double salary;
    private String bank_acc_num;
    private String ni_num;

    public EmployeeRequest(
            @JsonProperty("f_name") String fname,
            @JsonProperty("l_name") String lname,
            @JsonProperty("salary") double salary,
            @JsonProperty("bank_acc_num") String bank_acc_num,
            @JsonProperty("ni_num") String ni_num) {
        this.fName = fname;
        this.lName = lname;
        this.salary = salary;
        this.bank_acc_num = bank_acc_num;
        this.ni_num = ni_num;
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
