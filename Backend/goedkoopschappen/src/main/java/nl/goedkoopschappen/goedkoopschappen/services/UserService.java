package nl.goedkoopschappen.goedkoopschappen.services;


import nl.goedkoopschappen.goedkoopschappen.models.User;

import java.util.List;

public interface UserService {

    User save(User user) throws IllegalArgumentException;
    List<User> findAll();
    void delete(long id);
    User findByUsername (String username);
}
