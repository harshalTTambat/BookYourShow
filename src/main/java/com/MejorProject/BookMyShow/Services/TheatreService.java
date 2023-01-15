package com.MejorProject.BookMyShow.Services;

import com.MejorProject.BookMyShow.Enums.SeatType;
import com.MejorProject.BookMyShow.Models.TheatreEntity;
import com.MejorProject.BookMyShow.Models.TheatreSeatsEntity;
import com.MejorProject.BookMyShow.Repository.TheatreRepository;
import com.MejorProject.BookMyShow.Repository.TheatreSeatsRepository;
import com.MejorProject.BookMyShow.RequestDTO.TheatreRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    TheatreSeatsRepository theatreSeatsRepository;

    public String createTheatre(TheatreRequestDto theatreRequestDto)
    {
        TheatreEntity theatre = TheatreEntity.builder().
                name(theatreRequestDto.getName()).
                city(theatreRequestDto.getCity()).
                address(theatreRequestDto.getAddress()).
                build();

           // calling createTheatreSeats method
           List<TheatreSeatsEntity> theatreSeatsList = createTheatreSeats();
           // saving TheatreSeats to database
           theatreSeatsRepository.saveAll(theatreSeatsList);

           //int theater --> set theatreSeatsList
           theatre.setTheatreSeatsList(theatreSeatsList);

           // for each theatreSeat --> need to set this current theater also
           for(TheatreSeatsEntity theatreSeat: theatreSeatsList)
           {
               theatreSeat.setTheatre(theatre);
           }

           theatreRepository.save(theatre);

        return "Theatre created successfully";

    }

    private List<TheatreSeatsEntity> createTheatreSeats()
    {
        List<TheatreSeatsEntity> seatsList = new ArrayList<>();

        // by simply creating object of the TheatreSeatsEntity
        TheatreSeatsEntity theatreSeats1 = new TheatreSeatsEntity("1A", SeatType.SILVER,100);
        TheatreSeatsEntity theatreSeats2 = new TheatreSeatsEntity("1B", SeatType.SILVER,100);
        TheatreSeatsEntity theatreSeats3 = new TheatreSeatsEntity("1C", SeatType.SILVER,100);
        TheatreSeatsEntity theatreSeats4 = new TheatreSeatsEntity("1D", SeatType.SILVER,100);
        TheatreSeatsEntity theatreSeats5 = new TheatreSeatsEntity("1E", SeatType.SILVER,100);

        TheatreSeatsEntity theatreSeats6 = new TheatreSeatsEntity("2A", SeatType.GOLD,200);
        TheatreSeatsEntity theatreSeats7 = new TheatreSeatsEntity("2B", SeatType.GOLD,200);
        TheatreSeatsEntity theatreSeats8 = new TheatreSeatsEntity("2C", SeatType.GOLD,200);
        TheatreSeatsEntity theatreSeats9 = new TheatreSeatsEntity("2D", SeatType.GOLD,200);
        TheatreSeatsEntity theatreSeats10 = new TheatreSeatsEntity("2E", SeatType.GOLD,200);

        TheatreSeatsEntity theatreSeats11 = new TheatreSeatsEntity("3A", SeatType.PLATINUM,300);
        TheatreSeatsEntity theatreSeats12 = new TheatreSeatsEntity("3B", SeatType.PLATINUM,300);
        TheatreSeatsEntity theatreSeats13 = new TheatreSeatsEntity("3C", SeatType.PLATINUM,300);
        TheatreSeatsEntity theatreSeats14 = new TheatreSeatsEntity("3D", SeatType.PLATINUM,300);
        TheatreSeatsEntity theatreSeats15 = new TheatreSeatsEntity("3E", SeatType.PLATINUM,300);

        seatsList.add(theatreSeats1);
        seatsList.add(theatreSeats2);
        seatsList.add(theatreSeats3);
        seatsList.add(theatreSeats4);
        seatsList.add(theatreSeats5);
        seatsList.add(theatreSeats6);
        seatsList.add(theatreSeats7);
        seatsList.add(theatreSeats8);
        seatsList.add(theatreSeats9);
        seatsList.add(theatreSeats10);
        seatsList.add(theatreSeats11);
        seatsList.add(theatreSeats12);
        seatsList.add(theatreSeats13);
        seatsList.add(theatreSeats14);
        seatsList.add(theatreSeats15);

        return seatsList;

    }
}
