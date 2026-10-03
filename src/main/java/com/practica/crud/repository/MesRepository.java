package com.practica.crud.repository;

import com.practica.crud.model.Mes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesRepository extends JpaRepository<Mes, Long> {
}