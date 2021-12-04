package com.example.accessingdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaygroundRepository extends JpaRepository<Playground, Long> {
    List<Playground> findByColor(String color);
    List<Playground> findAll();
}
