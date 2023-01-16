package com.MejorProject.BookYourShow.Controllers;


import com.MejorProject.BookYourShow.RequestDTO.UserRequestDto;
import com.MejorProject.BookYourShow.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String createUser(@RequestBody() UserRequestDto userRequestDto)
    {
        return userService.createUser(userRequestDto);
    }


}
