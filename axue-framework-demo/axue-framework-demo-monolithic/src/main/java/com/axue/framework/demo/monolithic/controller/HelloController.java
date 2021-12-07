package com.axue.framework.demo.monolithic.controller;

import com.axue.framework.common.annotation.ResponseResult;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseResult
public class HelloController {

    @GetMapping("/hello")
    public User hello() {
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
