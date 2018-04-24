package plumbusx.service;

import plumbusx.model.Role;
import plumbusx.model.User;

import java.util.List;

/**
 * Created by i1yas on 04.05.2017.
 */
public interface UserService {
    void save(User user, String[] roles);

    User findByUsername(String username);
    User findById(Integer id);
    List<User> getAllByRole(Role role);

}
