package com.practica.crud.repository;

import com.practica.crud.model.Objgasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjgastoRepository extends JpaRepository<Objgasto, Long> {
}