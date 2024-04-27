package by.school.app.services;

import by.school.app.models.users.User;

/**
 *
 *
 * @author Victor Bakhanovich <victor.bahanovich@gmail.com>
 */
public interface SaUserService {
    User getUserById(final long id);

    User createUser(final User user);
}
