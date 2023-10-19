package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeRequest {
    private String f_name;
    private String l_name;
    private double salary;
    private String bank_acc_num;
    private String ni_num;

    public EmployeeRequest(
            @JsonProperty("f_name") String f_name,
            @JsonProperty("l_name") String l_name,
            @JsonProperty("salary") double salary,
            @JsonProperty("bank_acc_num") String bank_acc_num,
            @JsonProperty("ni_num") String ni_num) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.salary = salary;
        this.bank_acc_num = bank_acc_num;
        this.ni_num = ni_num;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
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
