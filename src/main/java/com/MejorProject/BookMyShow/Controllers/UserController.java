package com.MejorProject.BookMyShow.Controllers;


import com.MejorProject.BookMyShow.Models.UserEntity;
import com.MejorProject.BookMyShow.RequestDTO.UserRequestDto;
import com.MejorProject.BookMyShow.Services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create_user")
    public ResponseEntity<String> createUser(@RequestBody() UserRequestDto userRequestDto)
    {
        userService.createUser(userRequestDto);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }


}
