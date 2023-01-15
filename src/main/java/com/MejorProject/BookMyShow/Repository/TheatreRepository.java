package com.MejorProject.BookMyShow.Repository;

import com.MejorProject.BookMyShow.Models.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<TheatreEntity, Integer> {
}
