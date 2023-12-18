package com.jtf.sp.dynamodb.api.controller;

import com.jtf.sp.dynamodb.api.entity.User;
import com.jtf.sp.dynamodb.api.payload.response.ApiResponse;
import com.jtf.sp.dynamodb.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/user")
public class UserDetailsController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/addUser")
    public ApiResponse addUser(@RequestBody User user) {

        return new ApiResponse(HttpStatus.OK.value(), "User Details saved successfully.", userRepository.saveUser(user));
    }

    @GetMapping("/findUser/{userId}")
    public User getUserDetailsById(@PathVariable("userId") String userId) {
        return userRepository.findByUserId(userId);
    }

    @GetMapping("/getAllUsers")
    public List<User> findAllUserDetails() {
        return userRepository.findAllUserDetails();
    }

    @PutMapping("/updateUser/{userId}")
    public String updateUserUsingId(@PathVariable("userId") String usrerId, @RequestBody User user) {
        user.setId(usrerId);
        return userRepository.updateUserUsingId(usrerId, user);
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam String userId) {
        return userRepository.deleteUser(userId);
    }

}
