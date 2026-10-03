package com.practica.crud.repository;

import com.practica.crud.model.EstEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstEntRepository extends JpaRepository<EstEnt, Long> {
}