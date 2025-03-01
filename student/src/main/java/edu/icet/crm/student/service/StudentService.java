package edu.icet.crm.student.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.student.dto.Student;
import edu.icet.crm.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final ObjectMapper objectMapper;

    public void save(Student student) {
        studentRepository.save(
                objectMapper.convertValue(student, edu.icet.crm.student.entity.Student.class)
        );
    }

    public List<Student> findAll() {
        return objectMapper.convertValue(
                studentRepository.findAll(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Student.class)
        );
    }
}
