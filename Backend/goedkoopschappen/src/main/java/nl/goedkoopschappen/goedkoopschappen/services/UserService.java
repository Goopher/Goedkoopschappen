package nl.goedkoopschappen.goedkoopschappen.services;

import nl.goedkoopschappen.goedkoopschappen.dao.IUserDAO;
import nl.goedkoopschappen.goedkoopschappen.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Goopher on 12-2-2018.
 */

@Service(value = "userService")
public class UserService implements UserDetailsService, IUserService{

    @Autowired
    private IUserDAO userDAO;

    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userDAO.findByUserName(userId);
        if(user == null ){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getAuthority());
    }

    private List getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public List findAll() {
        List list = new ArrayList();
        userDAO.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id) {
        userDAO.delete(id);
    }

    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

}
