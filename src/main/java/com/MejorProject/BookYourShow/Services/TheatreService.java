package com.MejorProject.BookYourShow.Services;

import com.MejorProject.BookYourShow.Enums.SeatType;
import com.MejorProject.BookYourShow.Models.TheatreEntity;
import com.MejorProject.BookYourShow.Models.TheatreSeatsEntity;
import com.MejorProject.BookYourShow.Repository.TheatreRepository;
import com.MejorProject.BookYourShow.Repository.TheatreSeatsRepository;
import com.MejorProject.BookYourShow.RequestDTO.TheatreRequestDto;
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
        int totalSeats = 15;
        int TypeOfSeats=3;
        for (int i=0;i<totalSeats/TypeOfSeats;i++)
        {
           char ch = (char) ('A'+i);
           String seatNo = "1"+ch;
           TheatreSeatsEntity theatreSeats = new TheatreSeatsEntity(seatNo,SeatType.SILVER,100);
           seatsList.add(theatreSeats);
        }
        for (int i=0;i<totalSeats/TypeOfSeats;i++)
        {
            char ch = (char) ('A'+i);
            String seatNo = "2"+ch;
            TheatreSeatsEntity theatreSeats = new TheatreSeatsEntity(seatNo,SeatType.GOLD,100);
            seatsList.add(theatreSeats);
        }
        for (int i=0;i<totalSeats/TypeOfSeats;i++)
        {
            char ch = (char) ('A'+i);
            String seatNo = "3"+ch;
            TheatreSeatsEntity theatreSeats = new TheatreSeatsEntity(seatNo,SeatType.PLATINUM,100);
            seatsList.add(theatreSeats);
        }

        return seatsList;

    }
    public TheatreEntity findById(int id)
    {
        return theatreRepository.findById(id).get();
    }

}
