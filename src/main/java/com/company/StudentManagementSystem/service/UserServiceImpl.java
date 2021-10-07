package com.company.StudentManagementSystem.service;

import com.company.StudentManagementSystem.dto.UserDto;
import com.company.StudentManagementSystem.entity.User;
import com.company.StudentManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(UserDto userDto) throws ParseException {
        User user =new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setAdmissionDate(new SimpleDateFormat("yyyy-MM-dd").parse(userDto.getAdmissionDate()));
        user.setUsername(userDto.getUsername());
        user.setNationality(userDto.getNationality());
        user.setPhone(userDto.getPhone());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }


}
