package nl.goedkoopschappen.goedkoopschappen.dao;

import nl.goedkoopschappen.goedkoopschappen.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUserDAO extends CrudRepository<User, Long> {

    User findByUserName(String name);

}
