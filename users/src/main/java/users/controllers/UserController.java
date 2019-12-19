package users.controllers;

import users.models.User;
import users.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void add(@RequestBody User user){
        userService.add(user);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    public User getById(@PathVariable Integer id){
        return (User) userService.getById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users")
    public void update(@RequestBody User user){
        userService.update(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "users/{id}")
    public void delete(@PathVariable int id){
        userService.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> getAll(){
        return userService.getAll();
    }
}
