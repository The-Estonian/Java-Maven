package ee.devpipe.backend.controller;

import ee.devpipe.backend.model.User;
import ee.devpipe.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public String saveData(@RequestBody User user) {
        userRepository.save(user);
        return "Data saved!!";
    }

    @GetMapping
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
