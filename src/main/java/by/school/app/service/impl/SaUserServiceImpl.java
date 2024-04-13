package by.school.app.service.impl;

import by.school.app.model.User;
import by.school.app.repository.SaUserRepository;
import by.school.app.service.SaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SaUserServiceImpl.
 *
 * @author Victor Bakhanovich <victor.bahanovich@gmail.com>
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
