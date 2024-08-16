package org.example.matb02cucumber.controller;

import org.example.matb02cucumber.controller.dto.CreateUserDTO;
import org.example.matb02cucumber.infrastructure.adapters.entities.UserEntity;
import org.example.matb02cucumber.usecase.UserUsecases;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserUsecases userUsecases;

    public UserController(UserUsecases userUsecases) {
        this.userUsecases = userUsecases;
    }

    @PostMapping("/create")
    public ResponseEntity<UserEntity> createUser(@RequestBody CreateUserDTO user) {
        return ResponseEntity.ok(userUsecases.createUser(user));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserEntity>> getUsers() {
        return ResponseEntity.ok(userUsecases.getUsers());
    }
}
