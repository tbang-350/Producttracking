package com.example.Producttracking.repository;

import com.example.Producttracking.entity.Contractors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ContractorRepository extends JpaRepository<Contractors, Long> {
    @Query("SELECT s FROM Contractors s WHERE s.username =?1")
    Optional<Contractors> findContractorByUsername(String username);
}
