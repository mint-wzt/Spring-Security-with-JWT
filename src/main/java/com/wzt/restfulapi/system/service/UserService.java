package com.wzt.restfulapi.system.service;

import com.wzt.restfulapi.system.entity.User;
import com.wzt.restfulapi.system.enums.UserStatus;
import com.wzt.restfulapi.system.exception.UserNameAlreadyExistException;
import com.wzt.restfulapi.system.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    /**
     * 保存注册用户
     * @param registerUser
     */
    public void saveUser(Map<String, String> registerUser) throws UserNameAlreadyExistException{
        Optional<User> optionalUser = userRepository.findByUsername(registerUser.get("username"));
        if (optionalUser.isPresent()){
            throw new UserNameAlreadyExistException("User name already exist!Please choose another user name.");
        }
        User user = new User();
        user.setUsername(registerUser.get("username"));
        user.setPassword(bCryptPasswordEncoder.encode(registerUser.get("password")));
        user.setRoles("DEV,PM");
        user.setStatus(UserStatus.CAN_USE);
        userRepository.save(user);
    }

    public User findUserByUserName(String name) {
        return userRepository.findByUsername(name)
                .orElseThrow(()->new UsernameNotFoundException("No user found with username " + name));
    }

    public void deleteUserByUserName(String name){
        userRepository.deleteByUsername(name);
    }

    public Page<User> getAllUser(int pageNum, int pageSize) {
        return userRepository.findAll(PageRequest.of(pageNum, pageSize));
    }
}
