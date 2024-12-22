package com.example.Masson.Repository;

import com.example.Masson.Models.Contractors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstRepository extends JpaRepository<Contractors, Long> {

}
