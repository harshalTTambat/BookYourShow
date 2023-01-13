package com.MejorProject.BookMyShow.Models;

import com.MejorProject.BookMyShow.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Theatre_seats")
@Data
@NoArgsConstructor
@AllArgsConstructor
// the actual physical seats at particular theatre
public class TheatreSeatsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, columnDefinition = "seat_no")
    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private int rate;

    @ManyToOne
    @JoinColumn
    private TheatreEntity theatre;

}
