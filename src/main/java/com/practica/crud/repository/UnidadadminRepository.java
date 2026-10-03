package com.practica.crud.repository;

import com.practica.crud.model.Unidadadmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadadminRepository extends JpaRepository<Unidadadmin, Long> {
}