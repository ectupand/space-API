package com.example.demo.repository;

import com.example.demo.entity.Lord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LordRepository extends JpaRepository<Lord, Long> {
    List<Lord> findByAgeOrderByAgeAgeAsc();
}
