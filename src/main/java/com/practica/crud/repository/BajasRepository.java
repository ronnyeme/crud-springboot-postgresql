package com.practica.crud.repository;

import com.practica.crud.model.Bajas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BajasRepository extends JpaRepository<Bajas, Long> {
}