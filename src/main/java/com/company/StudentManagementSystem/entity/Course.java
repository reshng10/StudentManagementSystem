package com.company.StudentManagementSystem.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "course")
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String courseDescription;

    @ManyToMany(mappedBy = "courseList")
    private List<Student> enrolledStudentList;

    @JoinColumn(name ="department_id",referencedColumnName = "id")
    @ManyToOne
    private  Department departmentId;

    @JoinColumn(name ="teacher_id",referencedColumnName = "id")
    @ManyToOne
    private Teacher teacherId;

    public Course() {
    }

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

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public List<Student> getEnrolledStudentList() {
        return enrolledStudentList;
    }

    public void setEnrolledStudentList(List<Student> enrolledStudentList) {
        this.enrolledStudentList = enrolledStudentList;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    public Teacher getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Teacher teacherId) {
        this.teacherId = teacherId;
    }




}
