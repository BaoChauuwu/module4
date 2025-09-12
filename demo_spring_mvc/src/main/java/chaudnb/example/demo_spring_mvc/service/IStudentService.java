package chaudnb.example.demo_spring_mvc.service;

import chaudnb.example.demo_spring_mvc.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
}
