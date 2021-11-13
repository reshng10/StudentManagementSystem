package com.company.service.inter;

import com.company.dto.UserDto;
import com.company.entity.User;

import java.text.ParseException;
import java.util.List;

public interface UserService {

    List<User> findAll();
    void save(UserDto userDto) throws ParseException;
    void update(UserDto userDto) throws Exception;

}
