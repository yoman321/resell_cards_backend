package backend.resell_cards_backend.controllers;

import backend.resell_cards_backend.domains.User;
import backend.resell_cards_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public Optional<User> getUser(String email){
        return userService.getUserByEmail(email);
    }

    @PostMapping
    public void addNewUser(User user){
       userService.addNewUser(user);
    }

    @DeleteMapping
    public void deleteUser(User user){
        userService.removeUser(user);
    }

    @PutMapping
    public void updateUserPassword(User user, String newPassword){
        userService.updateUserPassword(user, newPassword);
    }

}
