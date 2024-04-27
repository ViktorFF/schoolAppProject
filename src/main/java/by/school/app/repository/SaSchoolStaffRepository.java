package by.school.app.repository;

import by.school.app.models.users.SchoolStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SaSchoolStaffRepository.
 *
 * @author Victor Bakhanovich <victor.bahanovich@gmail.com>
 */
@Repository
public interface SaSchoolStaffRepository extends JpaRepository<SchoolStaff, Long> {
    SchoolStaff findById(final long id);
}
