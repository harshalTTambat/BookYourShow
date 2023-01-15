package com.MejorProject.BookMyShow.Controllers;

import com.MejorProject.BookMyShow.Repository.TheatreRepository;
import com.MejorProject.BookMyShow.RequestDTO.TheatreRequestDto;
import com.MejorProject.BookMyShow.Services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreService theatreService;

    @PostMapping("/create_theatre")
    public String createTheatre(@RequestBody TheatreRequestDto theatreRequestDto)
    {
        return theatreService.createTheatre(theatreRequestDto);
    }
}
