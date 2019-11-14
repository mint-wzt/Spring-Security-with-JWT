package com.wzt.restfulapi.security.entity;

import com.wzt.restfulapi.security.service.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author shuang.kou
 * 获取当前请求的用户
 */
@Component
public class CurrentUser {

    private final UserDetailsServiceImpl userDetailsService;

    public CurrentUser(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public JwtUser getCurrentUser(){
        return (JwtUser) userDetailsService.loadUserByUsername(getCurrentUserName());
    }


    public static String getCurrentUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null &&authentication.getPrincipal() != null){
            return (String) authentication.getPrincipal();
        }
        return null;
    }
}
