package com.MejorProject.BookYourShow.RequestDTO;


import javax.persistence.*;
import lombok.Data;

@Data

public class UserRequestDto {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String mobileNo;

    @Column(nullable = false, unique = true)
    private String email;
}
