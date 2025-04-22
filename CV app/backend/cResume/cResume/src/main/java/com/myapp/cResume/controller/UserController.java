package com.myapp.cResume.controller;

import com.myapp.cResume.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class UserController {

    private UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

//    @PutMapping("/updateUser")
//    int UpdateUser(@RequestBody User user, @RequestParam("userId") Long userId){
//        return userService.updateUser(user, userId);
//    }


//    @PutMapping("/updateUser")
//    int UpdateUser(@RequestParam String userName, @RequestParam("userId") Long userId){
//        return userService.updateUser(userName, userId);
//    }
}
