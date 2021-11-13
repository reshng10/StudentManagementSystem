package com.company.controller;
import com.company.dto.CourseDto;
import com.company.entity.Course;
import com.company.entity.Department;
import com.company.service.inter.CourseService;
import com.company.service.inter.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/course")
public class AdminController {
    @Autowired
    private CourseService courseService;

   @Autowired
   private DepartmentService departmentService;

    @GetMapping("/list")
    public ModelAndView courseList(){
        ModelAndView modelAndView =new ModelAndView("courses");
        List<CourseDto> courseList =courseService.findAll();
        List<Department> departmentList =departmentService.findAll();

        modelAndView.addObject("courseDtoList",courseList);
        modelAndView.addObject("departmentList",departmentList);
        return modelAndView;
    }
    @PostMapping("/createCourse")
    public String createCourse(@ModelAttribute("courseDto") CourseDto courseDto){
           courseService.save(courseDto);
     return "redirect:/admin/course/list";
    }


    @PostMapping("/deleteCourse")
    public String deleteCourse(@RequestParam(name = "courseId",required = false) Integer id){
        courseService.deleteById(id);
        return "redirect:/admin/course/list";
    }

    @PostMapping("/updateCourse")
    public String updateCourse(@ModelAttribute("updateCourseDto") CourseDto courseDto){
         courseService.update(courseDto);
        return "redirect:/admin/course/list";
    }




    @ModelAttribute("courseDto")
    public CourseDto getCourse(){
        return new CourseDto();
    }
    @ModelAttribute("updateCourseDto")
    public CourseDto getCourse2(){
        return new CourseDto();
    }


}
