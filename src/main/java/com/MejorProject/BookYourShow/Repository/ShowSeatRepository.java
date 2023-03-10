package com.MejorProject.BookYourShow.Repository;

import com.MejorProject.BookYourShow.Models.ShowSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeatsEntity, Integer> {

}
