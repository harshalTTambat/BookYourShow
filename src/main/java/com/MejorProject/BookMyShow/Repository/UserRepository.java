package com.MejorProject.BookMyShow.Repository;

import com.MejorProject.BookMyShow.Models.UserEntity;
import com.MejorProject.BookMyShow.RequestDTO.UserRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

}


