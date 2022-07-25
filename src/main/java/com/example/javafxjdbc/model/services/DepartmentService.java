package com.example.javafxjdbc.model.services;

import com.example.javafxjdbc.model.dao.DaoFatory;
import com.example.javafxjdbc.model.dao.DepartmentDao;
import com.example.javafxjdbc.model.entities.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {

    private DepartmentDao dao = DaoFatory.createDepartmentDao();

    public List<Department> findAll() {
        return dao.findAll();
    }
}
