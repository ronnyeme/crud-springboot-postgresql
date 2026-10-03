package com.practica.crud.repository;

import com.practica.crud.model.Baja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BajaRepository extends JpaRepository<Baja, Long> {
}