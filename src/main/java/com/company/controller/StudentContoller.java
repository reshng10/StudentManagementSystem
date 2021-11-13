package com.company.controller;

import com.company.dto.UserDto;
import com.company.entity.User;
import com.company.repository.UserRepository;
import com.company.service.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentContoller {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


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
//        UserDto userDto = new UserDto();
//        modelAndView.addObject("userDto", userDto);
        return modelAndView;

    }
//
    @PostMapping("/saveStudent")
    public String saveEmployee(@ModelAttribute("userDto") UserDto userDto) throws ParseException {
        userService.save(userDto);
        return "redirect:/student/list";
    }

    @PostMapping("/StudentInfo")
    public ModelAndView updateStudent(@RequestParam(value = "id",required = false) Integer al) throws ParseException {
        ModelAndView modelAndView = new ModelAndView("student_detail");
        User user= userRepository.findById(al).get();
        modelAndView.addObject("userDto",user);
        System.out.println(user.getName());
        return modelAndView;

    }

    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute("userDto") UserDto userDto) throws Exception {
        System.out.println(userDto.getId());
      userService.update(userDto);
        return "redirect:/student/list";
    }

    @ModelAttribute
    public UserDto getUserDro(){
        return new UserDto();
    }
}
