package com.MejorProject.BookMyShow.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    private int duration;

    private Date releaseDate;

    //private List<MovieEntity> movieList;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<ShowEntity> showsList;


}
