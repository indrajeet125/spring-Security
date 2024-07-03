package c.security03.controller;

import c.security03.model.MyUser;
import c.security03.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    MyRepository repo;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("user")
    public MyUser createUser(@RequestBody MyUser myUser) {
        myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
        return repo.save(myUser);
    }
}
