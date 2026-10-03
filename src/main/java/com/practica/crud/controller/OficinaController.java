package com.practica.crud.controller;

import com.practica.crud.dto.OficinaDTO;
import com.practica.crud.service.OficinaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/oficina")
public class OficinaController {

    private final OficinaService oficinaService;

    public OficinaController(OficinaService oficinaService) {
        this.oficinaService = oficinaService;
    }

    // GET - LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<OficinaDTO>> listar() {
        return ResponseEntity.ok(oficinaService.listar());
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<OficinaDTO> buscarPorId(@PathVariable Long id) {
        return oficinaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - CREAR
    @PostMapping
    public ResponseEntity<OficinaDTO> crear(@RequestBody OficinaDTO dto) {

        OficinaDTO creado = oficinaService.crear(dto);

        return ResponseEntity.ok(creado);
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<OficinaDTO> actualizar(
            @PathVariable Long id,
            @RequestBody OficinaDTO dto) {

        return oficinaService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (oficinaService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}