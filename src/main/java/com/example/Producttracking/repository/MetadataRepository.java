package com.example.Producttracking.repository;

import com.example.Producttracking.entity.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MetadataRepository extends JpaRepository<Metadata, Long> {

    @Transactional
    @Modifying
    @Query(value = "insert into metadata(emp_id, geog) values (:emp_id,date,time ST_SetSRID(ST_Point( :lat, :lon ), 4326)\\:\\:geography)", nativeQuery = true)
    void createOrUpdate(final Long emp_id, final Double lat, final Double lon);
}
