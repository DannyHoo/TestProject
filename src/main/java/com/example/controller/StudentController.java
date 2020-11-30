package com.example.controller;

import com.example.domain.Student;
import com.example.repository.StudentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/demo")
    public String demo() {
        return "demo";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getAllStudent() {
        logger.info("yyyyyyyyyy号");
        return studentRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Student add(@Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        Student s = new Student();
        s.setAge(s.getAge());
        return studentRepository.save(student);
    }

    @RequestMapping(value = "/getOneStudent/{stuNum}", method = RequestMethod.GET)
    public Student getOneStudent(@PathVariable("stuNum") Integer stuNum) {
        return studentRepository.findOne(stuNum);
    }

    @RequestMapping(value = "/update/{stuNum}", method = RequestMethod.PUT)
    public Student update(@PathVariable("stuNum") Integer stuNum,
                          @RequestParam(value = "stuName", required = false, defaultValue = "china") String stuName) {
        Student s = new Student();
        return studentRepository.save(s);
    }

    @RequestMapping(value = "/delete/{stuNum}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("stuNum") Integer stuNum) {
        studentRepository.delete(stuNum);
    }
}
