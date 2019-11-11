package com.wzt.restfulapi.service;


import com.wzt.restfulapi.domain.User;
import com.wzt.restfulapi.exception.NotFoundException;
import com.wzt.restfulapi.exception.Result;
import com.wzt.restfulapi.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.wzt.restfulapi.util.Util.getNullPropertyNames;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public Object getUser(String id) throws NotFoundException {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new NotFoundException("user " + id + " is not exist!", Result.ErrorCode.USER_NOT_FOUND.getCode());
        }
        return userRepository.findById(id);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public User update(String id, User user) {
        User instance = userRepository.findById(id).orElse(null);

        String[] nullPropertyNames = getNullPropertyNames(user);
        BeanUtils.copyProperties(user, instance, nullPropertyNames);

        return userRepository.save(instance);
    }

}
