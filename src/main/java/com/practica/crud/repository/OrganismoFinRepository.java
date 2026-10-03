package com.practica.crud.repository;

import com.practica.crud.model.OrganismoFin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganismoFinRepository extends JpaRepository<OrganismoFin, Long> {
}