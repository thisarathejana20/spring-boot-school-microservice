package edu.icet.crm.student.controller;

import edu.icet.crm.student.dto.Student;
import edu.icet.crm.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Student student) {
        studentService.save(student);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> get() {
        return studentService.findAll();
    }

    @GetMapping("/school/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Student>> get(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.findBySchoolId(id));
    }
}
