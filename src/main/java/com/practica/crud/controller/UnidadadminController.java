package com.practica.crud.controller;

import com.practica.crud.dto.UnidadadminDTO;
import com.practica.crud.service.UnidadadminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unidadadmin")
public class UnidadadminController {

    private final UnidadadminService unidadadminService;

    public UnidadadminController(UnidadadminService unidadadminService) {
        this.unidadadminService = unidadadminService;
    }

    // GET - LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<UnidadadminDTO>> listar() {
        return ResponseEntity.ok(unidadadminService.listar());
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<UnidadadminDTO> buscarPorId(@PathVariable Long id) {
        return unidadadminService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - CREAR
    @PostMapping
    public ResponseEntity<UnidadadminDTO> crear(
            @RequestBody UnidadadminDTO dto) {

        UnidadadminDTO creado = unidadadminService.crear(dto);

        return ResponseEntity.ok(creado);
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<UnidadadminDTO> actualizar(
            @PathVariable Long id,
            @RequestBody UnidadadminDTO dto) {

        return unidadadminService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (unidadadminService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}