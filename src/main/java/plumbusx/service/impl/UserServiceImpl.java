package plumbusx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import plumbusx.model.Role;
import plumbusx.model.User;
import plumbusx.repository.RoleRepository;
import plumbusx.repository.UserRepository;
import plumbusx.service.UserService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by i1yas on 04.05.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user, String[] roles){
        user.setFirstname(user.getFirstname());
        user.setLastname(user.getLastname());
        user.setGroup(user.getGroup());
        user.setCourse(user.getCourse());
        user.setPost(user.getPost());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findByNameIn(Arrays.asList(roles))));

        //Set<Role> roles = new HashSet<>();
        //roles.add(roleRepository.getOne(1L));
        //user.setRoles(roles);
        userRepository.save(user);
    }
    @Override
    public User findByUsername(String  username){
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(Integer id){
        return userRepository.findOne(id);
    }

    @Override
    public List<User> getAllByRole(Role role) {
        return userRepository.findAllByRole(role);
    }
}
