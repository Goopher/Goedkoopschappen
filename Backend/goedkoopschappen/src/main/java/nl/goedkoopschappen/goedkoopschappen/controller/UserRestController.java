package nl.goedkoopschappen.goedkoopschappen.controller;

import nl.goedkoopschappen.goedkoopschappen.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Goopher on 12-2-2018.
 */

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/user", method= RequestMethod.GET)
    public List listUser() {
        return userService.findAll();
    }
}
