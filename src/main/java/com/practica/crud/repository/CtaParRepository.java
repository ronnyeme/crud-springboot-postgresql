package com.practica.crud.repository;

import com.practica.crud.model.CtaPar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CtaParRepository extends JpaRepository<CtaPar, Long> {
}