package com.example.Producttracking.repository;

import com.example.Producttracking.entity.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MetadataRepository extends JpaRepository<Metadata, Long> {

}
