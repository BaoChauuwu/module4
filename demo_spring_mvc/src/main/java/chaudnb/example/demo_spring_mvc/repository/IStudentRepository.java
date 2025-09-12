package chaudnb.example.demo_spring_mvc.repository;

import chaudnb.example.demo_spring_mvc.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
}
