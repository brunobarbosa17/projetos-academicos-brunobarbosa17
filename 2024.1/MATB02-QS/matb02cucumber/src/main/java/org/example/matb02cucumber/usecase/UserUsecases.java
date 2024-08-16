package org.example.matb02cucumber.usecase;

import org.example.matb02cucumber.controller.dto.CreateUserDTO;
import org.example.matb02cucumber.infrastructure.adapters.entities.UserEntity;
import org.example.matb02cucumber.infrastructure.adapters.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserUsecases {
    private final UserRepository userRepository;

    public UserUsecases(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(CreateUserDTO user) {
        var userEntity = new UserEntity(
                user.getName(),
                user.getEmail(),
                user.getRegister(),
                user.getPassword(),
                user.getTypeUser());
        return userRepository.save(userEntity);
    }

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }
}
