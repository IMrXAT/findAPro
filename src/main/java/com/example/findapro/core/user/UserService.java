package com.example.findapro.core.user;

import com.example.findapro.core.role.RoleRepository;
import com.example.findapro.domain.users.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @PersistenceContext
    private EntityManager entityManager;

    public UserService(EntityManager entityManager, UserRepository userRepository, RoleRepository roleRepository) {
        this.entityManager = entityManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }
    public List<User> AllUsers(){
        return userRepository.findAll();
    }

    public boolean saveUser(User user){
        User userFromDB = userRepository.findByUsername(user.getUsername());
        if (userFromDB != null){
            return false;
        }
        user.setRole(roleRepository.findRoleByRoleName("customer"));
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(Long userId){
        if (userRepository.findById(userId).isPresent()){
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}


