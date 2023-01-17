package com.MejorProject.BookYourShow.RequestDTO;

import com.MejorProject.BookYourShow.Models.MovieEntity;
import com.MejorProject.BookYourShow.Models.TheatreEntity;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowRequestDto {

    private LocalDate showDate;

    private LocalTime showTime;

    private String movieName;

    private int theatreId;

}
