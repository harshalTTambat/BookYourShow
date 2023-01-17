package com.MejorProject.BookYourShow.Controllers;


import com.MejorProject.BookYourShow.Models.MovieEntity;
import com.MejorProject.BookYourShow.RequestDTO.MovieRequestDto;
import com.MejorProject.BookYourShow.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/findByName/{name}")
    public MovieEntity findByName(@PathVariable(name = "name") String name)
    {
        return movieService.findByName(name);
    }


}
