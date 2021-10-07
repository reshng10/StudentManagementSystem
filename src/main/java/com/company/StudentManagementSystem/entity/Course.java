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
    private List<User> enrolledUserList;

    @JoinColumn(name ="department_id",referencedColumnName = "id")
    @ManyToOne
    private  Department departmentId;

    @JoinColumn(name ="user_id",referencedColumnName = "id")
    @ManyToOne
    private User teacherId;

    public Course() {
    }

    public List<User> getEnrolledUserList() {
        return enrolledUserList;
    }

    public void setEnrolledUserList(List<User> enrolledUserList) {
        this.enrolledUserList = enrolledUserList;
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

    public List<User> getEnrolledStudentList() {
        return enrolledUserList;
    }


    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    public User getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(User teacherId) {
        this.teacherId = teacherId;
    }




}
