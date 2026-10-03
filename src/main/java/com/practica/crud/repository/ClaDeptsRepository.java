package com.practica.crud.repository;

import com.practica.crud.model.ClaDepts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaDeptsRepository extends JpaRepository<ClaDepts, Long> {
}