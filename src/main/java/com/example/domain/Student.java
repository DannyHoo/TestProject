package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;


@Entity
@Table(name = "t_student")
public class Student{

    @Id
    @GeneratedValue
    private Integer id;

    private String studentNo;

    private String studentName;

    private Integer age;


    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public Student setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public Student setStudentNo(String studentNo) {
        this.studentNo = studentNo;
        return this;
    }

    public String getStudentName() {
        return studentName;
    }

    public Student setStudentName(String studentName) {
        this.studentName = studentName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Student setAge(Integer age) {
        this.age = age;
        return this;
    }
}