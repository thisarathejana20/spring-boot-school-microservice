package edu.icet.crm.school.repository;

import edu.icet.crm.school.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School,Integer> {
}
