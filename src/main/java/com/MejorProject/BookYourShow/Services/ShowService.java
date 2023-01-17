package com.MejorProject.BookYourShow.Services;

import com.MejorProject.BookYourShow.Models.MovieEntity;
import com.MejorProject.BookYourShow.Models.ShowEntity;
import com.MejorProject.BookYourShow.Models.TheatreEntity;
import com.MejorProject.BookYourShow.Repository.MovieRepository;
import com.MejorProject.BookYourShow.Repository.ShowRepository;
import com.MejorProject.BookYourShow.Repository.TheatreRepository;
import com.MejorProject.BookYourShow.RequestDTO.ShowRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

    @Autowired
    ShowRepository showRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheatreRepository theatreRepository;
    public void addShow(ShowRequestDto showRequestDto)
    {
        // for setting movieName & TheatreID
        // need to get movieRepository & get TheatreRepository

        MovieEntity movie = movieRepository.findByName(showRequestDto.getMovieName());
        TheatreEntity theatre = theatreRepository.findById(showRequestDto.getTheatreId()).get();
// creating show object
        ShowEntity show = new ShowEntity();
        show.setShowDate(showRequestDto.getShowDate());
        show.setShowTime(showRequestDto.getShowTime());
        show.setMovie(movie);
        show.setTheatre(theatre);

        showRepository.save(show);

    }
}
