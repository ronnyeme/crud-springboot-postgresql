package com.practica.crud.repository;

import com.practica.crud.model.Trasfe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrasfeRepository extends JpaRepository<Trasfe, Long> {
}