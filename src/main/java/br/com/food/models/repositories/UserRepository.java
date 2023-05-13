package br.com.food.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.food.models.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{}
