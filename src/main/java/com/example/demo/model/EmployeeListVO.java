package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListVO {
    private List<EmployeeVO> employees;

    public EmployeeListVO() {
        this.employees  = new ArrayList<>();
    }

    public List<EmployeeVO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeVO> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "EmployeeListVO{" +
                "employees=" + employees +
                '}';
    }
}
