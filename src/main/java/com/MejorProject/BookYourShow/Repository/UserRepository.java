package com.MejorProject.BookYourShow.Repository;

import com.MejorProject.BookYourShow.Models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

}


