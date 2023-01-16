package com.MejorProject.BookYourShow.Models;

import com.MejorProject.BookYourShow.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "show_seats")
@Data
@NoArgsConstructor
@AllArgsConstructor

// the virtual seats while booking tickets
public class ShowSeatsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String seatNo;


    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private boolean booked;

    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    private ShowEntity show;

    @ManyToOne
    @JoinColumn
    private TicketEntity ticket;

}
