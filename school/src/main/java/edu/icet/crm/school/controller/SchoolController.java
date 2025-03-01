package edu.icet.crm.school.controller;

import edu.icet.crm.school.dto.FullSchoolResponse;
import edu.icet.crm.school.dto.School;
import edu.icet.crm.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping("/school")
    @ResponseStatus(HttpStatus.CREATED)
    public void createSchool(@RequestBody School school) {
        schoolService.save(school);
    }

    @GetMapping("/school")
    @ResponseStatus(HttpStatus.OK)
    public List<School> getAll() {
        return schoolService.findAll();
    }

    @GetMapping("/with-students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<FullSchoolResponse> getWithStudents(@PathVariable Integer id) {
        return ResponseEntity.ok(schoolService.findByIdWithStudents(id));
    }
}
