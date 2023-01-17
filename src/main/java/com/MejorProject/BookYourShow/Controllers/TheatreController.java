package com.MejorProject.BookYourShow.Controllers;

import com.MejorProject.BookYourShow.Models.TheatreEntity;
import com.MejorProject.BookYourShow.RequestDTO.TheatreRequestDto;
import com.MejorProject.BookYourShow.Services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/findById/{id}")
    public TheatreEntity findById(@RequestParam int id)
    {
        return theatreService.findById(id);
    }

}
