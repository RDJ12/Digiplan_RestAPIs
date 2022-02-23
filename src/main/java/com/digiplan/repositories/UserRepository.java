package com.digiplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digiplan.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
