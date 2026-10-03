package com.practica.crud.repository;

import com.practica.crud.model.Codcont;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodcontRepository extends JpaRepository<Codcont, Long> {
}