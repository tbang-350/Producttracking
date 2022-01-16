package com.example.Producttracking.repository;

import com.example.Producttracking.entity.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetadataRepository extends JpaRepository<Metadata, Long> {
    
}
