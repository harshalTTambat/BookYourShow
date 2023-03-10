package com.MejorProject.BookYourShow.RequestDTO;

import javax.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
public class MovieRequestDto {

    @Column(nullable = false, unique = true)
    private String name;

    private int duration;

    private Date releaseDate;
}
