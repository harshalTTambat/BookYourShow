package com.MejorProject.BookYourShow.Controllers;

import com.MejorProject.BookYourShow.RequestDTO.BookTicketRequestDto;
import com.MejorProject.BookYourShow.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/book_ticket")
    public String bookTicket(@RequestBody BookTicketRequestDto bookTicketRequestDto) {
        try {
            return ticketService.bookTicket(bookTicketRequestDto);
        }catch (Exception e)
        {
            return "Sorry.. ticket not booked";
        }
    }

}
