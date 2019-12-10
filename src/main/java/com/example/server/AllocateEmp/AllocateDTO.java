package com.example.server.AllocateEmp;

import com.example.server.department.Department;
import com.example.server.employee.Employee;

import java.time.LocalDate;

public class AllocateDTO {
    private long id;
    private int percentage;
    private int duration;
    private LocalDate from_date;
    private LocalDate to_date;

    private Employee employee;
    private String d_no;

    private Department department;
    private String e_no;
}
