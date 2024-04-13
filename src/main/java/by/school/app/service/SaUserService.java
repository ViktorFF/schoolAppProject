package by.school.app.service;

import by.school.app.model.User;

/**
 *
 *
 * @author Victor Bakhanovich <victor.bahanovich@gmail.com>
 */
public interface SaUserService {
    User getUserById(final long id);

    User createUser(final User user);
}
