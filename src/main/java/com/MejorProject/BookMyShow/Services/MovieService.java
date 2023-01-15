package com.MejorProject.BookMyShow.Services;

import com.MejorProject.BookMyShow.Models.MovieEntity;
import com.MejorProject.BookMyShow.Repository.MovieRepository;
import com.MejorProject.BookMyShow.RequestDTO.MovieRequestDto;
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
}
