package com.company.service.inter;

import com.company.dto.CourseDto;
import com.company.entity.Course;

import java.util.List;

public interface CourseService {
    List<CourseDto> findAll();
    void save(CourseDto courseDto);
    void deleteById(Integer id);
    void update(CourseDto course);
}
