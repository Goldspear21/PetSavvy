package petsavvy.pet.controllers;

import petsavvy.pet.model.User;
import petsavvy.pet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public List<User> getUserById(@PathVariable int userId) {
        return userService.findByUserID(userId);
    }

    @GetMapping("/search/username")
    public List<User> searchByUsername(@RequestParam String username) {
        return userService.findByUsernameContaining(username);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable int userId, @RequestBody User user) {
        user.setUserID(userId);
        return userService.saveUser(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteByUserID(userId);
        userService.resetAutoIncrement();
    }
}
