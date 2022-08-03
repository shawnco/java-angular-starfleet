package com.example.demo.starship;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StarshipRepository extends JpaRepository<Starship, Integer> {

    @Query("SELECT s FROM Starship s WHERE s.registry = ?1")
    Optional<Starship> findStarshipByRegistry(String registry);
}
