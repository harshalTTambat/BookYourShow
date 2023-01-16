package com.MejorProject.BookYourShow.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Shows")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate showDate;

    private LocalTime showTime;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @ManyToOne
    @JoinColumn
    private MovieEntity movie;

    @ManyToOne
    @JoinColumn
    private TheatreEntity theatre;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<ShowSeatsEntity> showSeatsList;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<TicketEntity> ticketList;

}
