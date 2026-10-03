package com.practica.crud.controller;

import com.practica.crud.dto.OrguserDTO;
import com.practica.crud.service.OrguserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orguser")
public class OrguserController {

    private final OrguserService orguserService;

    public OrguserController(OrguserService orguserService) {
        this.orguserService = orguserService;
    }

    // GET - LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<OrguserDTO>> listar() {
        return ResponseEntity.ok(orguserService.listar());
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<OrguserDTO> buscarPorId(@PathVariable Long id) {
        return orguserService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - CREAR
    @PostMapping
    public ResponseEntity<OrguserDTO> crear(@RequestBody OrguserDTO dto) {

        OrguserDTO creado = orguserService.crear(dto);

        return ResponseEntity.ok(creado);
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<OrguserDTO> actualizar(
            @PathVariable Long id,
            @RequestBody OrguserDTO dto) {

        return orguserService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (orguserService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}