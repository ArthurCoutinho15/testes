package br.newtonpaiva.testeSecurity.Service;

import br.newtonpaiva.testeSecurity.Model.UserRequest;
import br.newtonpaiva.testeSecurity.Repository.UserRepository;
import br.newtonpaiva.testeSecurity.Security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String generateToken(String username, String role) {
        return JwtUtil.generateToken(username, role);
    }

    public String extractUsername(String token) {
        return JwtUtil.extractUsername(token);
    }

    public String extractUserRole(String token) {
        return JwtUtil.extractUserRole(token);
    }

    public String authenticateUser(String username, String password) {
        UserRequest user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return generateToken(username, user.getRole());
        }
        return null;
    }

    public void saveUser(UserRequest user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public UserRequest findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean updateUser(String id, UserRequest updatedUser) {
        UserRequest existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(updatedUser.getUsername());
            if (updatedUser.getPassword() != null) {
                existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
            }
            existingUser.setRole(updatedUser.getRole());
            userRepository.save(existingUser);
            return true;
        }
        return false;
    }

    public boolean deleteUser(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
