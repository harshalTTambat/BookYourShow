package com.MejorProject.BookYourShow.Controllers;


import com.MejorProject.BookYourShow.RequestDTO.ShowRequestDto;
import com.MejorProject.BookYourShow.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/add_show")
    public String addShow(@RequestBody ShowRequestDto showRequestDto)
    {
        showService.addShow(showRequestDto);
        return "Show added successfully";
    }
}
