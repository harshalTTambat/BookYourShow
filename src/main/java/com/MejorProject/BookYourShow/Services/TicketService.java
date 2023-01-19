package com.MejorProject.BookYourShow.Services;

import com.MejorProject.BookYourShow.Models.ShowEntity;
import com.MejorProject.BookYourShow.Models.ShowSeatsEntity;
import com.MejorProject.BookYourShow.Models.TicketEntity;
import com.MejorProject.BookYourShow.Models.UserEntity;
import com.MejorProject.BookYourShow.Repository.ShowRepository;
import com.MejorProject.BookYourShow.Repository.TicketRepository;
import com.MejorProject.BookYourShow.Repository.UserRepository;
import com.MejorProject.BookYourShow.RequestDTO.BookTicketRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    UserRepository userRepository;

    public String bookTicket(BookTicketRequestDto bookTicketRequestDto)throws Exception
    {
        //getting seats request
        List<String> requestedSeats = bookTicketRequestDto.getRequestedSeats();
        //finding show
        ShowEntity show = showRepository.findById(bookTicketRequestDto.getShowId()).get();
        //finding user
        UserEntity user = userRepository.findById(bookTicketRequestDto.getUserId()).get();

        // getting showSeats from show entity
        List<ShowSeatsEntity> showSeatsList = show.getShowSeatsList();

        // validation --> the requested seats can allocate or not
        List<ShowSeatsEntity> bookedSeats = new ArrayList<>();

        for (ShowSeatsEntity showSeat: showSeatsList)
        {
            String seatNo = showSeat.getSeatNo();
            if(showSeat.isBooked() == false && requestedSeats.contains(seatNo))
            {
                bookedSeats.add(showSeat);
            }
        }

        if(bookedSeats.size() != requestedSeats.size())
        {
            // this means some of requested seats are not available
            throw new Exception("sorry..Some seats are not available");
        }

    // if exception is not thrown, means seats are available and added in BookedSeats list

        // creating ticket
        TicketEntity ticket = new TicketEntity();

        // now need to calculate amount
        // setting booked status & other variables in showSeats entity
        double totalAmount = 0;
        double multiplier = show.getMultiplier();
        double rate = 0;
        String seatAllocation = "";
        for(ShowSeatsEntity booked: bookedSeats)
        {
            booked.setBooked(true);
            booked.setBookedAt(new Date());
            booked.setTicket(ticket);
            booked.setShow(show);

            String seatNo = booked.getSeatNo();
            char ch = seatNo.charAt(0);
            if (ch == '1') rate = 100;
            else if(ch == '2') rate = 200;
            else rate = 300;

            seatAllocation = seatAllocation + seatNo + ",";
            totalAmount = totalAmount + multiplier * rate;

        }

        ticket.setBooked_on(new Date());
        ticket.setAmount(totalAmount);
        ticket.setUser(user);
        ticket.setShow(show);
        ticket.setBookedSeats(bookedSeats);
        ticket.setAllowed_seats(seatAllocation);

        ticketRepository.save(ticket);
        return "Ticket book successfully";

        // bidirectional mapping is pending

    }
}
