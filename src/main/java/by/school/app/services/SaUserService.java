package by.school.app.services;

import by.school.app.models.users.User;

/**
 * SaUserService.
 *
 * @author Victor Bakhanovich &lt;victor.bahanovich@gmail.com&gt;
 */
public interface SaUserService {
    User getUserById(final long id);

    User createUser(final User user);
}
