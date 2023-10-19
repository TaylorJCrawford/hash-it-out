package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeRequest {
    private String f_Name;
    private String l_Name;
    private double salary;
    private String bank_Acc_Num;
    private String niNum;


    @JsonCreator
    public EmployeeRequest(
         @JsonProperty("f_Name") String f_Name,
         @JsonProperty("l_Name")String l_Name,
         @JsonProperty("salary")double salary,
         @JsonProperty("bank_acc_num") String bank_Acc_Num,
         @JsonProperty("ni_num") String niNum)
         {

        this.f_Name = f_Name;
        this.l_Name = l_Name;
        this.salary = salary;
        this.bank_Acc_Num = bank_Acc_Num;
        this.niNum = niNum;

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

    public String getBank_Acc_Num() {
        return bank_Acc_Num;
    }

    public void setBank_Acc_Num(String bank_Acc_Num) {
        this.bank_Acc_Num = bank_Acc_Num;
    }



    public String getNiNum() {
        return niNum;
    }



    public void setNiNum(String niNum) {
        this.niNum = niNum;
    }
}
