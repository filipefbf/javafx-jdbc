package com.example.javafxjdbc.model.services;

import com.example.javafxjdbc.model.entities.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {

    public List<Department> findAll() {
        List<Department> list = new ArrayList<>();
        list.add(new Department(1, "Books"));
        list.add(new Department(2, "Computer"));
        list.add(new Department(3, "Electronics"));
        return list;
    }
}
