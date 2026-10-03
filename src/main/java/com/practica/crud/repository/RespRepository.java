package com.practica.crud.repository;

import com.practica.crud.model.Resp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespRepository extends JpaRepository<Resp, Long> {
}