package edu.icet.crm.school.service;

import com.fasterxml.jackson.databind.ObjectMapper;
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
}
