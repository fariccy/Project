package com.example.Masson.Repository;

import com.example.Masson.Models.Homeowner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface HomeownerRepository extends JpaRepository<Homeowner, Long> {


}


