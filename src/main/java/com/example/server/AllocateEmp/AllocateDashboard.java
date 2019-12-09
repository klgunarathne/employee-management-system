package com.example.server.AllocateEmp;

import com.example.server.department.Department;
import lombok.Data;

import java.util.Optional;

@Data
public class AllocateDashboard {
    private Department department;
    private Float percentage;
}
