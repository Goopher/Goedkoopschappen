package nl.goedkoopschappen.goedkoopschappen.services;

import nl.goedkoopschappen.goedkoopschappen.models.User;

import java.util.List;

/**
 * Created by Goopher on 12-2-2018.
 */
public interface IUserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
}