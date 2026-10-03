package com.practica.crud.controller;

import com.practica.crud.dto.ActualDTO;
import com.practica.crud.service.ActualService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actual")
public class ActualController {

    private final ActualService actualService;

    public ActualController(ActualService actualService) {
        this.actualService = actualService;
    }

    // GET - LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<ActualDTO>> listar() {
        return ResponseEntity.ok(actualService.listar());
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<ActualDTO> buscarPorId(@PathVariable Long id) {

        return actualService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - CREAR
    @PostMapping
    public ResponseEntity<ActualDTO> crear(@RequestBody ActualDTO dto) {

        ActualDTO creado = actualService.crear(dto);

        return ResponseEntity.ok(creado);
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<ActualDTO> actualizar(
            @PathVariable Long id,
            @RequestBody ActualDTO dto) {

        return actualService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (actualService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}