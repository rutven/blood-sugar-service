package name.legkodymov.poc.sugar.monitor.service;

import javassist.NotFoundException;
import name.legkodymov.poc.sugar.monitor.entity.User;
import name.legkodymov.poc.sugar.monitor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorService {

    private final UserRepository userRepository;

    @Autowired
    public MonitorService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findOne(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) throws NotFoundException {
        User userToUpdate = userRepository.findOne(user.getId());
        if (userToUpdate != null) {
            userToUpdate.setFirstName(user.getFirstName());
            userToUpdate.setLastName(user.getLastName());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setAge(user.getAge());
            return userRepository.save(userToUpdate);
        } else {
            throw new NotFoundException("User with id = " + user.getId() + " not found");
        }
    }
}
