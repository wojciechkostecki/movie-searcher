package org.example.service;

import org.example.exception.LoginAlreadyUsedException;
import org.example.mapper.UserMapper;
import org.example.model.Role;
import org.example.model.dto.UserDTO;
import org.example.repository.UserRepository;
import org.example.repository.UserRoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    private final UserRoleRepository userRoleRepository;

    public RegisterService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                           UserMapper userMapper, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.userRoleRepository = userRoleRepository;
    }

    public void registerUser(UserDTO dto) {
        if (userRepository.findByLogin(dto.getLogin()).isPresent()) {
            throw new LoginAlreadyUsedException("Login is already taken");
        }

        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        dto.setRoles(Collections.singleton(userRoleRepository.findByRole(Role.USER).get()));
        userRepository.save(userMapper.toEntity(dto));
    }
}
