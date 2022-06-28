package com.works.repositories;

import com.works.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // select * from user where email = ? and password = ?
    Optional<User> findByEmailEqualsAndPasswordEquals(String email, String password);

    Optional<User> findByEmailEqualsIgnoreCaseAndPasswordEqualsIgnoreCase(String email, String password);

    List<User> findByNameContainsOrSurnameContainsAllIgnoreCase(String name, String surname);


}