package com.MejorProject.BookYourShow.Services;


import com.MejorProject.BookYourShow.Models.UserEntity;
import com.MejorProject.BookYourShow.Repository.UserRepository;
import com.MejorProject.BookYourShow.RequestDTO.UserRequestDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String createUser(UserRequestDto userRequestDto)
    {
        //Converting userDTO to Entity
        // using @Builder making object of User
        UserEntity user = UserEntity.builder().
                name(userRequestDto.getName()).
                mobileNo(userRequestDto.getMobileNo()).
                email(userRequestDto.getEmail()).
                build();
        try{
            // saving entity in repository/ Database
            // it might cause an issue
            userRepository.save(user);
        }
        catch (Exception e)
        {
            return "Sorry!! User not created.. Try again";
        }
        return "Successfully User created";
    }
}
