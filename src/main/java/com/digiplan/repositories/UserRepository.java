package com.digiplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digiplan.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUsernameAndPassword(String username, String password);

    public User findByUsernameAndPhoneNumber(String username, Long phoneNumber);

    @Query(value = "select * from alignwise_users where groupid=(select groupid from alignwise_users where username=:username and typeofuser='DoctorAdmin')", nativeQuery = true)
    public List<User> findAllUsersList(@Param("username") String username);
}
