package com.wecode.realestateagency.Repositories;

import com.wecode.realestateagency.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findUserByUsername(String username);
}
