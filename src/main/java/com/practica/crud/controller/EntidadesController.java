package com.practica.crud.controller;

import com.practica.crud.dto.EntidadesDTO;
import com.practica.crud.service.EntidadesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entidades")
public class EntidadesController {

    private final EntidadesService entidadesService;

    public EntidadesController(EntidadesService entidadesService) {
        this.entidadesService = entidadesService;
    }

    // GET - LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<EntidadesDTO>> listar() {
        return ResponseEntity.ok(entidadesService.listar());
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<EntidadesDTO> buscarPorId(@PathVariable Long id) {

        return entidadesService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - CREAR
    @PostMapping
    public ResponseEntity<EntidadesDTO> crear(@RequestBody EntidadesDTO dto) {

        EntidadesDTO creado = entidadesService.crear(dto);

        return ResponseEntity.ok(creado);
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<EntidadesDTO> actualizar(
            @PathVariable Long id,
            @RequestBody EntidadesDTO dto) {

        return entidadesService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (entidadesService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}