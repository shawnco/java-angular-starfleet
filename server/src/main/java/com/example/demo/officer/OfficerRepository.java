package com.example.demo.officer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfficerRepository extends JpaRepository<Officer, Integer> {
    @Query("SELECT o FROM Officer o WHERE o.name = ?1")
    Optional<Officer> findOfficerByName(String name);
}
