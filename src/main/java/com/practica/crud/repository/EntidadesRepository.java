package com.practica.crud.repository;

import com.practica.crud.model.Entidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntidadesRepository extends JpaRepository<Entidades, Long> {
}