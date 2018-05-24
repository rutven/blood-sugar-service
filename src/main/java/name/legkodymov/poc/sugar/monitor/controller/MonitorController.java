package name.legkodymov.poc.sugar.monitor.controller;


import javassist.NotFoundException;
import name.legkodymov.poc.sugar.monitor.entity.User;
import name.legkodymov.poc.sugar.monitor.service.MonitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MonitorController {

    public final static String USERS_PATH = "/users";

    private final MonitorService monitorService;

    private static final Logger log = LoggerFactory.getLogger(MonitorController.class);

    @Autowired
    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @GetMapping(value = USERS_PATH)
    public List<User> getAllUsers() {
        System.out.println("get all users");
        final List<User> allUsers = monitorService.getAllUsers();
        for (User user : allUsers) {
            System.out.println(user);
        }
        return allUsers;
    }

    @GetMapping(value = USERS_PATH + "/{id}")
    public User getUserById(@PathVariable("id") String id) {
        System.out.println("get user by id = " + id);
        final User user = monitorService.getUserById(id);
        System.out.println(user);
        return user;
    }

    @PostMapping(value = USERS_PATH)
    public User createUser(@RequestBody User user) {
        System.out.println("create user - " + user);
        final User newUser = monitorService.createUser(user);
        System.out.println("new user - " + newUser);
        return newUser;
    }

    @PutMapping(value = USERS_PATH)
    public User updateUser(@RequestBody User user) {
        System.out.println("update user " + user);
        try {
            final User newUser = monitorService.updateUser(user);
            System.out.println("new user" + newUser);
            return newUser;
        } catch (NotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
