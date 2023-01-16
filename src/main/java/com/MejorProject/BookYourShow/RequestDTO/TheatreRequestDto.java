package com.MejorProject.BookYourShow.RequestDTO;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class TheatreRequestDto {

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private String city;

    private String address;
}
