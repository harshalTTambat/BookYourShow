package com.MejorProject.BookYourShow.Repository;

import com.MejorProject.BookYourShow.Models.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<ShowEntity ,Integer> {
}
