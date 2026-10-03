package com.practica.crud.controller;

import com.practica.crud.dto.RevalDTO;
import com.practica.crud.service.RevalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reval")
public class RevalController {

    private final RevalService revalService;

    public RevalController(RevalService revalService) {
        this.revalService = revalService;
    }

    // GET - LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<RevalDTO>> listar() {
        return ResponseEntity.ok(revalService.listar());
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<RevalDTO> buscarPorId(@PathVariable Long id) {
        return revalService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - CREAR
    @PostMapping
    public ResponseEntity<RevalDTO> crear(@RequestBody RevalDTO dto) {

        RevalDTO creado = revalService.crear(dto);

        return ResponseEntity.ok(creado);
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<RevalDTO> actualizar(
            @PathVariable Long id,
            @RequestBody RevalDTO dto) {

        return revalService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (revalService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}