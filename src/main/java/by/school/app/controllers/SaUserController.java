package by.school.app.controllers;

import by.school.app.models.users.User;
import by.school.app.services.SaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * SaUserController.
 *
 * @author Victor Bakhanovich <victor.bahanovich@gmail.com>
 */
@RestController
@RequestMapping("/users")
public class SaUserController {
    private final SaUserService saUserService;

    @Autowired
    public SaUserController(SaUserService saUserService) {
        this.saUserService = saUserService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody final User user) {
        return saUserService.createUser(user);
    }
}
