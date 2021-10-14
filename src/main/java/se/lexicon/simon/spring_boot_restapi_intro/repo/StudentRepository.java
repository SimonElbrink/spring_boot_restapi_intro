package se.lexicon.simon.spring_boot_restapi_intro.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.simon.spring_boot_restapi_intro.model.Student;

import java.util.List;

/**
 * Student Repository
 * JPA with Hibernate can help us quickly access a database storage where students a stored.
 * With the help of Queries we can send operations to the database.
 */
public interface StudentRepository extends JpaRepository<Student, String> {

    @Query("SELECT s FROM Student s WHERE UPPER(s.firstName) LIKE UPPER(CONCAT('%',:name,'%')) " +
            "OR " +
            "UPPER(s.lastName) LIKE UPPER(CONCAT('%', :name, '%')) ")
    List<Student> findAllByNameContainingIgnoreCase(@Param("name") String name);
}
