package com.wzt.restfulapi.controller;

import com.wzt.restfulapi.domain.User;
import com.wzt.restfulapi.exception.NotFoundException;
import com.wzt.restfulapi.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUserList() {
        return userService.getUserList();
    }

    @ApiOperation(value = "添加用户", notes = "添加用户")
    @PostMapping(value = "/users")
    @ResponseStatus(HttpStatus.CREATED)
    public Object addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @ApiOperation(value = "获取用户信息", notes = "根据id获取用户信息")
    @GetMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object getUser(@PathVariable("id") String id) throws NotFoundException {
        return userService.getUser(id);
    }

    @ApiOperation(value = "删除用户", notes = "根据id删除用户")
    @DeleteMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
    }

    @ApiOperation(value = "更新用户", notes = "更新用户")
    @PatchMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@PathVariable("id") String id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @ApiOperation(value = "测试")
    @GetMapping(value = "/test")
    @ResponseStatus(HttpStatus.OK)
    public String test() {
        return "test ok!";
    }
}
