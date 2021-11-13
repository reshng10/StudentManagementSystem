package com.company.repository;

import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
    List<User> findAll();

//
//    @Query(value = "update User  set name =userD where u.id=:id" ,nativeQuery = true)
//    void update(UserDto userDto,Integer id);
}
