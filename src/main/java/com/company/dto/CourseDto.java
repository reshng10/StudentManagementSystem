package com.company.dto;


import com.company.entity.Department;
import com.company.entity.User;

import java.util.List;

public class CourseDto {
    private Integer id;
    private String name;
    private String description;
    private List<User> userDtoList;
    private DepartmentDto departmentDto;
    private User teacher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUserDtoList() {
        return userDtoList;
    }

    public void setUserDtoList(List<User> userDtoList) {
        this.userDtoList = userDtoList;
    }

    public DepartmentDto getDepartmentDto() {
        return departmentDto;
    }

    public void setDepartmentDto(DepartmentDto departmentDto) {
        this.departmentDto = departmentDto;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }
}
