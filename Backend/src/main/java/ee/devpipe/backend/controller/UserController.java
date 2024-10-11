package ee.devpipe.backend.controller;

import ee.devpipe.backend.model.AppUser;
import ee.devpipe.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public String saveData(@RequestBody AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "Data saved!!";
    }

    @GetMapping
    public List<AppUser> getAllUser() {
        return userRepository.findAll();
    }
}
