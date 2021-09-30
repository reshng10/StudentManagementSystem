package com.company.StudentManagementSystem.entity;


import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "surname",nullable = false)
    private String surname;

    @Column(name = "gmail" , nullable = false)
    private String gmail;

    @Column(name = "phone")
    private String phoneNumber;

    @OneToMany(mappedBy = "teacherId")
    private List<Course> courseList;


    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department departmentId;
}
