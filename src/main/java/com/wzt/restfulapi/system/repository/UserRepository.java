package com.wzt.restfulapi.system.repository;

import com.wzt.restfulapi.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String username);

    @Transactional
    void deleteByUsername( String username);

}
