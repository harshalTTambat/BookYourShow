package com.MejorProject.BookYourShow.Services;

import com.MejorProject.BookYourShow.Models.MovieEntity;
import com.MejorProject.BookYourShow.Repository.MovieRepository;
import com.MejorProject.BookYourShow.RequestDTO.MovieRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieRequestDto movieRequestDto)
    {
        MovieEntity movie = MovieEntity.builder().
                name(movieRequestDto.getName()).
                duration(movieRequestDto.getDuration()).
                releaseDate(movieRequestDto.getReleaseDate()).
                build();
        try{
            movieRepository.save(movie);
        }
        catch (Exception e)
        {
            return "Sorry!!..Movie not added";
        }
        return "Successfully added movie";
    }
    public MovieEntity findByName(String name)
    {
        return movieRepository.findByName(name);
    }
}
