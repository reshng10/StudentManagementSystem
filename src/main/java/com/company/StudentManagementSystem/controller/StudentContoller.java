package com.company.StudentManagementSystem.controller;

import com.company.StudentManagementSystem.dto.UserDto;
import com.company.StudentManagementSystem.entity.User;
import com.company.StudentManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentContoller {

    @Autowired
    private UserService userService;


    @GetMapping("/list")
    public ModelAndView getStudentList() {
        ModelAndView modelAndView = new ModelAndView("students");
        List<User> studentList = userService.findAll();
      //  System.out.println("===========" + studentList.get(0));
        modelAndView.addObject("list", studentList);
        return modelAndView;
    }

    @GetMapping("/showNewStudentForm")
    public ModelAndView showNewEmployeeForm() {
        ModelAndView modelAndView = new ModelAndView("new_student");
        UserDto userDto = new UserDto();
        modelAndView.addObject("userDto", userDto);
        return modelAndView;

    }
//
    @PostMapping("/saveStudent")
    public String saveEmployee(@ModelAttribute("userDto") UserDto userDto) throws ParseException {
        userService.save(userDto);
        return "redirect:/student/list";
    }
}
