package edu.icet.crm.school.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.school.client.StudentClient;
import edu.icet.crm.school.dto.FullSchoolResponse;
import edu.icet.crm.school.dto.School;
import edu.icet.crm.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final ObjectMapper objectMapper;
    private final StudentClient studentClient;

    public void save(School school) {
        schoolRepository.save(objectMapper
                .convertValue(school, edu.icet.crm.school.entity.School.class));
    }

    public List<School> findAll() {
        return objectMapper.convertValue(
                schoolRepository.findAll(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, School.class)
        );
    }

    public FullSchoolResponse findByIdWithStudents(Integer id) {
        edu.icet.crm.school.entity.School school = schoolRepository.findById(id)
                .orElse(edu.icet.crm.school.entity.School
                        .builder()
                        .name("School not found")
                        .email("School not found")
                        .build());

        // now we need to communicate with student microservice to get students
        //with the help of Feign client we can call student microservice
        //it will call to one of their endpoints and fetch the data
        var students = studentClient.findAllStudentsBySchoolId(id); //
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
