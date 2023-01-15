package com.MejorProject.BookMyShow.Controllers;


import com.MejorProject.BookMyShow.RequestDTO.MovieRequestDto;
import com.MejorProject.BookMyShow.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add_movie")
    public String addMovie(@RequestBody()MovieRequestDto movieRequestDto)
    {
        return movieService.addMovie(movieRequestDto);
    }

}
