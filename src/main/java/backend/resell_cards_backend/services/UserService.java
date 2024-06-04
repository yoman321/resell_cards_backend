package backend.resell_cards_backend.services;

import backend.resell_cards_backend.domains.User;
import backend.resell_cards_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Optional<User> getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public void addNewUser(User newUser){

        if (getOptionalUser(newUser).isPresent()){
            throw new IllegalStateException("The user already exist");
        }
        userRepository.save(newUser);
    }

    public void removeUser(User user){

        if (!getOptionalUser(user).isPresent()){
            throw new IllegalStateException("The user does not exist");
        }
        userRepository.delete(user);
    }

    public void updateUserPassword(User user, String newPassword){

        Optional<User> optionalUser = getOptionalUser(user);
        User databaseUser;
        if (!optionalUser.isPresent()){
            throw new IllegalStateException("The user does  not exist");
        }

        databaseUser = optionalUser.get();
        if (databaseUser.getEmail().equals(user.getEmail()) && databaseUser.getPassword().equals(user.getPassword())){
            databaseUser.setPassword(newPassword);
            userRepository.save(databaseUser);
        }

    }

    private Optional<User> getOptionalUser(User user){
        Example<User> exampleUser = Example.of(user);
        return userRepository.findById(exampleUser.getProbe().getId());
    }
}
