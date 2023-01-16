package com.MejorProject.BookYourShow.RequestDTO;


import jakarta.persistence.Column;
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
