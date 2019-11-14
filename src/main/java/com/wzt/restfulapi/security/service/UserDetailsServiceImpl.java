package com.wzt.restfulapi.security.service;

import com.wzt.restfulapi.security.entity.JwtUser;
import com.wzt.restfulapi.system.entity.User;
import com.wzt.restfulapi.system.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findUserByUserName(s);
        return new JwtUser(user);
    }
}
