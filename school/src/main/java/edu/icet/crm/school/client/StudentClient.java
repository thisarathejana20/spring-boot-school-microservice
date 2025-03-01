package edu.icet.crm.school.client;

import edu.icet.crm.school.dto.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//to communicate with other microservices
@FeignClient(name = "student-service", url = "${application.config.students-url}")
public interface StudentClient {

    @GetMapping("/school/{id}")
    List<Student> findAllStudentsBySchoolId(@PathVariable Integer id);
}
