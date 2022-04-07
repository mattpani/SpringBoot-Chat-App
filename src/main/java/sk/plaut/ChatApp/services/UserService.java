package sk.plaut.ChatApp.services;

import sk.plaut.ChatApp.data.Users;
import sk.plaut.ChatApp.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String addUser(Users user) {
        Users foundUser = userRepository.findByUsername(user.getUsername());
        if (foundUser != null) {
            return "už je zaregistrovany";
        }
        userRepository.save(user);
        return "uspešne zaregistrovany";
    }

    public Users findByName(String name) {
        return userRepository.findByUsername(name);
    }
}

