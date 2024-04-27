package by.school.app.repository;

import by.school.app.models.users.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SaStudentRepository.
 *
 * @author Victor Bakhanovich <victor.bahanovich@gmail.com>
 */
@Repository
public interface SaStudentRepository extends JpaRepository<Student, Long> {
    Student findById(final long id);
}
