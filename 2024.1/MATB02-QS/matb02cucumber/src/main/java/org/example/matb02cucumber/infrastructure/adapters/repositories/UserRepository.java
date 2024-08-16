package org.example.matb02cucumber.infrastructure.adapters.repositories;

import org.example.matb02cucumber.infrastructure.adapters.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
