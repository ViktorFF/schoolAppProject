package by.school.app.repository;

import by.school.app.models.users.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SaParentRepository.
 *
 * @author Victor Bakhanovich &lt;victor.bahanovich@gmail.com&gt;
 */
@Repository
public interface SaParentRepository extends JpaRepository<Parent, Long> {
    Parent findById(final long id);
}
