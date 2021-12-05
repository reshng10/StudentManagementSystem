package com.company.service;

import com.company.dto.DepartmentDto;
import com.company.entity.Department;
import com.company.repository.DepartmentRepository;
import com.company.service.inter.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentDto> findAll()
    {
        List<DepartmentDto> departmentDtoList = new ArrayList<>();
        List<Department> list =  departmentRepository.findAll();
        list.forEach(department -> {
            DepartmentDto departmentDto = new DepartmentDto();
            departmentDto.setId(department.getId());
            departmentDto.setName(department.getName());

            departmentDtoList.add(departmentDto);
        });
        return  departmentDtoList;
    }
    @Override
    public void deleteDepartment(Integer id){
        departmentRepository.deleteById(id);
    }

    @Override
    public void updateDepartment(DepartmentDto departmentDto) {
        System.out.println("---------------    "+departmentDto.getId());
      Department department=  departmentRepository.findById(departmentDto.getId()).get();
      department.setId(departmentDto.getId());
      department.setName(departmentDto.getName());
      departmentRepository.save(department);
    }

    @Override
    public void  saveDepartment(DepartmentDto departmentDto){
        Department department = new Department();
        department.setName(departmentDto.getName());
        departmentRepository.save(department);
    }
}
