package com.practica.crud.repository;

import com.practica.crud.model.Reval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevalRepository extends JpaRepository<Reval, Long> {
}