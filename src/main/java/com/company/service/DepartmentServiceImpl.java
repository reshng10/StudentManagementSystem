package com.company.service;

import com.company.entity.Department;
import com.company.repository.DepartmentRepository;
import com.company.service.inter.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll(){
        return  departmentRepository.findAll();
    }
}
