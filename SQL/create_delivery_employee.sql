CREATE DATABASE Hash_it_out;

CREATE TABLE employee (
    employee_id int PRIMARY KEY AUTO_INCREMENT,
    f_name varchar(255),
    l_name varchar(255),
    salary decimal,
    bank_acc_num varchar(20),
    ni_num varchar(11)
);

CREATE TABLE delivery_employee (
    employee_id int PRIMARY KEY,
    FOREIGN KEY(employee_id) REFERENCES employee(employee_id)
);




