package chaudnb.example.demo_spring_mvc.repository;

import chaudnb.example.demo_spring_mvc.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepository implements IStudentRepository {

    private static List<Student> students = new ArrayList<>();
    static{
        students.add(new Student(1,"Chau"));
    }

    @Override
    public List<Student> findAll() {
        return students;
    }
}
