package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeRequest {

    private String fName;
    private String lName;
    private double salary;
    private String bankAccNum;
    private String niNum;

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

    @JsonCreator
    public EmployeeRequest (
            @JsonProperty("fName") String fName,
            @JsonProperty("lName") String lName,
            @JsonProperty("salary") Double salary,
            @JsonProperty("bankAccNum") String bankAccNum,
            @JsonProperty("niNum") String niNum
    )
    {
        this.fName=fName;
        this.lName=lName;
        this.salary=salary;
        this.bankAccNum=bankAccNum;
        this.niNum=niNum;
    }
}
