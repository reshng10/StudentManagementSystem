package com.company.StudentManagementSystem.service;

import com.company.StudentManagementSystem.dto.UserDto;
import com.company.StudentManagementSystem.entity.User;

import java.text.ParseException;
import java.util.List;

public interface UserService {

    List<User> findAll();
    void save(UserDto userDto) throws ParseException;

}
