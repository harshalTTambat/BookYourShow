package com.MejorProject.BookYourShow.Services;

import com.MejorProject.BookYourShow.Models.*;
import com.MejorProject.BookYourShow.Repository.MovieRepository;
import com.MejorProject.BookYourShow.Repository.ShowRepository;
import com.MejorProject.BookYourShow.Repository.ShowSeatRepository;
import com.MejorProject.BookYourShow.Repository.TheatreRepository;
import com.MejorProject.BookYourShow.RequestDTO.ShowRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    ShowRepository showRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;
    public void addShow(ShowRequestDto showRequestDto)
    {
        // creating show object
        ShowEntity show = ShowEntity.builder().
                showDate(showRequestDto.getShowDate()).
                showTime(showRequestDto.getShowTime()).
                multiplier(showRequestDto.getMultiplier()).
                build();

        // for setting movieName & TheatreID
        // movie & theatre entity needed
        //getting from movieRepository & get TheatreRepository
        MovieEntity movie = movieRepository.findByName(showRequestDto.getMovieName());
        TheatreEntity theatre = theatreRepository.findById(showRequestDto.getTheatreId()).get();
        show.setTheatre(theatre);
        show.setMovie(movie);

        // for Bidirectional mapping
        // Optional things
        movie.getShowsList().add(show);
        theatre.getListOfShows().add(show);

        // for setting show seats
        //because when we are adding the show , it should be set
        List<ShowSeatsEntity> showSeatsEntityList = createShowSeats(theatre.getTheatreSeatsList());
        show.setShowSeatsList(showSeatsEntityList);

        // for each show seat --> we need to mark that it is belonged to which show(foreign key)
        for (ShowSeatsEntity showSeats: showSeatsEntityList)
        {
            showSeats.setShow(show);
        }
        movieRepository.save(movie);
        theatreRepository.save(theatre);
        // this will automatically save show
        //showRepository.save(show);
        // this does not need to do because show is child of movie and its bidirectional mapping

    }
    public List<ShowSeatsEntity> createShowSeats(List<TheatreSeatsEntity> theatreSeatsEntities)
    {
       // creating show seats which is replica of theatre seats
       // seats number and parameters we will get from theatre seats

        List<ShowSeatsEntity> showSeatsList = new ArrayList<>();
        for(TheatreSeatsEntity theatreSeats : theatreSeatsEntities)
        {
            ShowSeatsEntity showSeatsEntity = ShowSeatsEntity.builder().
                    seatNo(theatreSeats.getSeatNo()).
                    seatType(theatreSeats.getSeatType()).
                    build();
            showSeatsList.add(showSeatsEntity);
        }
        showSeatRepository.saveAll(showSeatsList);
        return showSeatsList;
    }
}
