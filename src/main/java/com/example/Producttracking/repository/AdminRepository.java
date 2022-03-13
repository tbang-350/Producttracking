package com.example.Producttracking.repository;

import com.example.Producttracking.entity.Admins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admins, Long> {

}
