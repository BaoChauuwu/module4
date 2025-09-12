package chaudnb.example.demo_spring_mvc.controller;

import chaudnb.example.demo_spring_mvc.entity.Student;
import chaudnb.example.demo_spring_mvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {
@Autowired
    StudentService studentService;
    @GetMapping("/students")
    public String showStudents(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("students",students);
        return "list";
    }
}
