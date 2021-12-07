package com.axue.framework.demo.monolithic.controller;

import com.axue.framework.common.annotation.ResponseResult;
import com.axue.framework.common.result.Result;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseResult
public class HelloController {

    @GetMapping("/hello")
    public Result<User> hello() {
        return Result.success(new User("axue","123456"));
    }

    @GetMapping("/hello1")
    public User hello1() {
        return new User("axue","123456");
    }

    @Data
    static class User {

        private String name;

        private String password;

        public User(String name, String password) {
            this.name = name;
            this.password = password;
        }
    }

}
