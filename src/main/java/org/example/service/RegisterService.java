package org.example.service;

import org.example.exception.LoginAlreadyUsedException;
import org.example.mapper.UserMapper;
import org.example.model.dto.UserDTO;
import org.example.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    public RegisterService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public void registerUser(UserDTO dto){
        if (userRepository.findByLogin(dto.getLogin()).isPresent()) {
            throw new LoginAlreadyUsedException("Login is already taken");
        }

        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(userMapper.toEntity(dto));
    }
}
