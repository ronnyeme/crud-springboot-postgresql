package com.practica.crud.repository;

import com.practica.crud.model.Passw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswRepository extends JpaRepository<Passw, Long> {
}