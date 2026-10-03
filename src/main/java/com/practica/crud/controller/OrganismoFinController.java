package com.practica.crud.controller;

import com.practica.crud.dto.OrganismoFinDTO;
import com.practica.crud.service.OrganismoFinService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organismo-fin")
public class OrganismoFinController {

    private final OrganismoFinService organismoFinService;

    public OrganismoFinController(OrganismoFinService organismoFinService) {
        this.organismoFinService = organismoFinService;
    }

    // GET - LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<OrganismoFinDTO>> listar() {
        return ResponseEntity.ok(organismoFinService.listar());
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<OrganismoFinDTO> buscarPorId(@PathVariable Long id) {
        return organismoFinService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - CREAR
    @PostMapping
    public ResponseEntity<OrganismoFinDTO> crear(@RequestBody OrganismoFinDTO dto) {

        OrganismoFinDTO creado = organismoFinService.crear(dto);

        return ResponseEntity.ok(creado);
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<OrganismoFinDTO> actualizar(
            @PathVariable Long id,
            @RequestBody OrganismoFinDTO dto) {

        return organismoFinService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (organismoFinService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}