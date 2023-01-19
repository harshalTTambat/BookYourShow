package com.MejorProject.BookYourShow.RequestDTO;

import lombok.Data;

import java.util.List;

@Data
public class BookTicketRequestDto {

    private int userId;
    private int showId;
    private List<String> requestedSeats;

}
