package com.MejorProject.BookYourShow.Models;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Theatre")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TheatreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String city;

    private String address;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<TheatreSeatsEntity> TheatreSeatsList;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    private List<ShowEntity> listOfShows;

}
