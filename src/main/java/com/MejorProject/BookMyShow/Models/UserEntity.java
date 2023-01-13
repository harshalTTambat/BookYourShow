package com.MejorProject.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String mobileNo;

   // private List<TicketEntity> ticketList;

    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP) // timestamp for both date and time
    private Date createdOn;

    @UpdateTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedOn;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<TicketEntity> ticketList;



}
