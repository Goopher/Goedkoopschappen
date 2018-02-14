package nl.goedkoopschappen.goedkoopschappen.dao;

import nl.goedkoopschappen.goedkoopschappen.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDAO extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
