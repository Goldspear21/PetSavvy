package petsavvy.pet.services;

import petsavvy.pet.model.User;
import petsavvy.pet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // --get methods

    public List<User> getAllUsers() {
       return userRepository.findAll();
    }

    public List<User> findByUsernameContaining(String username) {
        return userRepository.findByUsernameContainingIgnoreCase(username);
    }

    public List<User> findByUserMail(String userMail) {
        return userRepository.findByUserMail(userMail);
    }

    public List<User> findByUserID(int userID) {
        return userRepository.findUserByUserID(userID);
    }

    public List<User> findByPassword(String password) {
        return userRepository.findByPassword(password);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public String findUserMailByUserID(int userID) {
        return userRepository.findUserMailByUserID(userID);
    }

    // --save methods

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // --update methods

    public void resetAutoIncrement() {
        userRepository.resetAutoIncrement();
    }

    public void updatePasswordByUserID(String password, int userID) {
        userRepository.updatePasswordByUserID(password, userID);
    }

    public void updateUserMailByUserID(String userMail, int userID) {
        userRepository.updateUserMailByUserID(userMail, userID);
    }

    public void updateUserNameByUserID(String username, int userID) {
        userRepository.updateUserNameByUserID(username, userID);
    }

    // --delete method

    public void deleteByUserID(int userID) {
        userRepository.deleteByUserID(userID);
    }

}
