package com.practica.crud.repository;

import com.practica.crud.model.Orguser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrguserRepository extends JpaRepository<Orguser, Long> {
}