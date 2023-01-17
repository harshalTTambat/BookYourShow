package com.MejorProject.BookYourShow.Repository;

import com.MejorProject.BookYourShow.Models.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheatreRepository extends JpaRepository<TheatreEntity, Integer> {

    List<TheatreEntity> findByCity(String city);
}
