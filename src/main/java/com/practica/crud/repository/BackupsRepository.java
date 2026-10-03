package com.practica.crud.repository;

import com.practica.crud.model.Backups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackupsRepository extends JpaRepository<Backups, Long> {
}