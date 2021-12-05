package com.company.service.inter;

import com.company.dto.DepartmentDto;
import com.company.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> findAll();
    void deleteDepartment(Integer id);
    void updateDepartment(DepartmentDto departmentDto);
    void saveDepartment(DepartmentDto departmentDto);
}
