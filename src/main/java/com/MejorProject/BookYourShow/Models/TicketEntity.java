package com.MejorProject.BookYourShow.Models;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Ticket")
@Data
@NoArgsConstructor

public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String allowed_seats;
    private double amount;
    private Date booked_on;

    @ManyToOne
    @JoinColumn
    private UserEntity user;

    @ManyToOne
    @JoinColumn
    private ShowEntity show;

    @OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL)
    private List<ShowSeatsEntity> bookedSeats;


}
