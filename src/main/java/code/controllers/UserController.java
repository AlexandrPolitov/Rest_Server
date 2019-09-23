package code.controllers;

import java.util.List;

import code.models.LogPass;
import code.models.User;
import code.database.dao.UserDAO;
import code.models.UserInfo;
import code.services.UserDataService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(value = "/api" ,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserDataService userDataService;

    @Autowired
    public UserController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userDataService.getUserById(id);
    }

    @PostMapping("/authUser")
    public User authUser(@RequestBody LogPass logPass) {
        return userDataService.authUser(logPass.getName(),
                logPass.getPassword());
    }

    @GetMapping("/users")
    public List<UserInfo> getUsers() {
        return userDataService.getAllUsers();
    }

    @PostMapping("/user/add")
    public User addUser(@RequestBody User user) {
        return userDataService.insertUser(user.getName(), user.getPassword(),
                user.getEmail());
    }

    @PutMapping("/user/update")
    public void updateUser(@RequestBody User user) {
        userDataService.updateUser(user.getId(), user.getName(),
                user.getPassword(), user.getEmail());
    }

    @DeleteMapping("/user/delete")
    public void deleteUSer(@RequestBody Integer id) {
        userDataService.deleteUserById(id);
    }
}
