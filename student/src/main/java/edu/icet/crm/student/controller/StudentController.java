package edu.icet.crm.student.controller;

import edu.icet.crm.student.dto.Student;
import edu.icet.crm.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Student student) {
        studentService.save(student);
    }

    @GetMapping("/student")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> get() {
        return studentService.findAll();
    }
}
