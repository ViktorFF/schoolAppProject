package by.school.app.repository;

import by.school.app.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository.
 *
 * @author Victor Bakhanovich &lt;victor.bahanovich@gmail.com&gt;
 */
@Repository
public interface SaUserRepository extends JpaRepository<User, Long> {
    User findById(final long id);
}
