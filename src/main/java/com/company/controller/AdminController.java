package com.company.controller;
import com.company.dto.CourseDto;
import com.company.dto.DepartmentDto;
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
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CourseService courseService;

   @Autowired
   private DepartmentService departmentService;

    @GetMapping("/course/list")
    public ModelAndView courseList(){
        ModelAndView modelAndView =new ModelAndView("courses");
        List<CourseDto> courseList =courseService.findAll();
        List<DepartmentDto> departmentList =departmentService.findAll();

        modelAndView.addObject("courseDtoList",courseList);
        modelAndView.addObject("departmentList",departmentList);
        return modelAndView;
    }
    @PostMapping("/course/createCourse")
    public String createCourse(@ModelAttribute("courseDto") CourseDto courseDto){
           courseService.save(courseDto);
     return "redirect:/admin/course/list";
    }


    @PostMapping("/course/deleteCourse")
    public String deleteCourse(@RequestParam(name = "courseId",required = false) Integer id){
        courseService.deleteById(id);
        return "redirect:/admin/course/list";
    }

    @PostMapping("/course/updateCourse")
    public String updateCourse(@ModelAttribute("updateCourseDto") CourseDto courseDto){
         courseService.update(courseDto);
        return "redirect:/admin/course/list";
    }

    @GetMapping("/department/list")
    public ModelAndView getDepartmentList(){
        ModelAndView modelAndView = new ModelAndView("department");
         List<DepartmentDto> departmentList = departmentService.findAll();
         modelAndView.addObject("departmentList",departmentList);
         return  modelAndView;
    }

    @PostMapping("/department/deleteDepartment")
        public String deleteDepartment(@RequestParam(required = false, name = "id") Integer id){
            departmentService.deleteDepartment(id);
            return "redirect:/admin/department/list";
        }

        @PostMapping("/department/update")
        public String updateDepartment(@ModelAttribute("departmentDTO") DepartmentDto departmentDto){
             departmentService.updateDepartment(departmentDto);
             return "redirect:/admin/department/list";
        }

    @PostMapping("/department/save")
    public String saveDepartment(@ModelAttribute("department") DepartmentDto departmentDto){
        departmentService.saveDepartment(departmentDto);
        return "redirect:/admin/department/list";
    }



    @ModelAttribute("courseDto")
    public CourseDto getCourse(){
        return new CourseDto();
    }
    @ModelAttribute("updateCourseDto")
    public CourseDto getCourse2(){
        return new CourseDto();
    }

    @ModelAttribute("departmentDTO")
    public DepartmentDto getDepartmentDto(){
        return new DepartmentDto();
    }

    @ModelAttribute("department")
    public DepartmentDto get(){
        return new DepartmentDto();
    }


    }


