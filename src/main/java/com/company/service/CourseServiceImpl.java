package com.company.service;

import com.company.dto.CourseDto;
import com.company.dto.DepartmentDto;
import com.company.entity.Course;
import com.company.entity.Department;
import com.company.repository.CourseRepository;
import com.company.service.inter.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;



    @Override
    public List<CourseDto> findAll()
    {
        List<CourseDto> courseDtoList = new ArrayList<>();
    List<Course> courseList= courseRepository.findAll();
    courseList.forEach(course -> {
        CourseDto courseDto =new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setName(course.getName());
        courseDto.setDescription(course.getCourseDescription());
        DepartmentDto d= new DepartmentDto();
        d.setId(course.getDepartmentId().getId());
        d.setName(course.getDepartmentId().getName());
        courseDto.setDepartmentDto(d);
        courseDto.setTeacher(course.getTeacherId());
        courseDto.setUserDtoList(course.getEnrolledUserList());
        courseDtoList.add(courseDto);
    });
//    System.out.println(courseDtoList.get(0).getDepartmentDto().getId() +"--------------------------"+ courseDtoList.get(0).getDepartmentDto().getName());
      return  courseDtoList;
    }


    @Override
    public void deleteById(Integer id) {
        courseRepository.deleteById(id);
    }


    @Override
    public void save(CourseDto courseDto) {
        Course course = new Course();
        course.setId(courseDto.getId());
        course.setName(courseDto.getName());
        Department department =new Department();
        department.setId(courseDto.getDepartmentDto().getId());
        department.setName(courseDto.getDepartmentDto().getName());
        course.setDepartmentId(department);
        course.setCourseDescription(courseDto.getDescription());
        course.setTeacherId(courseDto.getTeacher());
        course.setEnrolledUserList(courseDto.getUserDtoList());
        courseRepository.save(course);
    }

    @Override
    public void update(CourseDto courseDto) {
       Course course= courseRepository.findById(courseDto.getId()).get();
       course.setName(courseDto.getName());
       course.setCourseDescription(courseDto.getDescription());
        Department department =new Department();
        department.setId(courseDto.getDepartmentDto().getId());
        department.setName(courseDto.getDepartmentDto().getName());
       course.setDepartmentId(department);
       course.setTeacherId(courseDto.getTeacher());
       course.setEnrolledUserList(courseDto.getUserDtoList());
       courseRepository.save(course);
    }

}
