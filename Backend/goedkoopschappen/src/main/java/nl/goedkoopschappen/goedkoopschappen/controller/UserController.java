package nl.goedkoopschappen.goedkoopschappen.controller;

import nl.goedkoopschappen.goedkoopschappen.dto.UserDTO;
import nl.goedkoopschappen.goedkoopschappen.models.Product;
import nl.goedkoopschappen.goedkoopschappen.models.User;
import nl.goedkoopschappen.goedkoopschappen.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List<User> listUser(){
        return userService.findAll();
    }

    @RequestMapping(value = "/searchUser", params = "username")
    public UserDTO findByUserName (@RequestParam(value = "username")String username){
        User user = userService.findByUsername(username);
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setId(user.getId());
        userDTO.setSalary(user.getSalary());
        userDTO.setAge(user.getAge());
        return userDTO;

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User create(@RequestBody User user){
        return userService.save(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Long id){
        userService.delete(id);
        return "success";
    }

}

