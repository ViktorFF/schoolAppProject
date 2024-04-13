package by.school.app.repository;

import by.school.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository.
 *
 * @author Victor Bakhanovich <victor.bahanovich@gmail.com>
 */
@Repository
public interface SaUserRepository extends JpaRepository<User, Long> {
    User findById(final long id);
}
