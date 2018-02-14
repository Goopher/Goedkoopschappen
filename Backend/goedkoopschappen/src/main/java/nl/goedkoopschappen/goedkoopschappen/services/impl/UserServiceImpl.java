package nl.goedkoopschappen.goedkoopschappen.services.impl;

import nl.goedkoopschappen.goedkoopschappen.dao.IUserDAO;
import nl.goedkoopschappen.goedkoopschappen.models.User;
import nl.goedkoopschappen.goedkoopschappen.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private IUserDAO iUserDAO;

    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = iUserDAO.findByUsername(userId);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        iUserDAO.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public User findByUsername(String username) {
        return iUserDAO.findByUsername(username);
    }

    @Override
    public void delete(long id) {
        iUserDAO.delete(id);
    }

    @Override
    public User save(User user) {
        return iUserDAO.save(user);
    }
}
