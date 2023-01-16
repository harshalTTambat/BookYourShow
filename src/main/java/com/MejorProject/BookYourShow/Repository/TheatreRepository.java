package com.MejorProject.BookYourShow.Repository;

import com.MejorProject.BookYourShow.Models.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<TheatreEntity, Integer> {
}
