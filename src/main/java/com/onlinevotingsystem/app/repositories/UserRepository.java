package com.onlinevotingsystem.app.repositories;

import com.onlinevotingsystem.app.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByRegisterNo(String registerNo);  // Find a user by their register number
}
