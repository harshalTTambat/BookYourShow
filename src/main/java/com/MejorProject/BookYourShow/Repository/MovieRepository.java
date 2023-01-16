package com.MejorProject.BookYourShow.Repository;

import com.MejorProject.BookYourShow.Models.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
}
