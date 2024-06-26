package by.school.app.services.impl;

import by.school.app.models.users.User;
import by.school.app.repository.SaUserRepository;
import by.school.app.services.SaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SaUserServiceImpl.
 *
 * @author Victor Bakhanovich &lt;victor.bahanovich@gmail.com&gt;
 */
@Service
public class SaUserServiceImpl implements SaUserService {
    private final SaUserRepository userRepository;

    @Autowired
    public SaUserServiceImpl( SaUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
