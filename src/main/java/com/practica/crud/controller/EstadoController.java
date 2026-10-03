package com.practica.crud.controller;

import com.practica.crud.dto.EstadoDTO;
import com.practica.crud.service.EstadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    // GET - LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<EstadoDTO>> listar() {
        return ResponseEntity.ok(estadoService.listar());
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<EstadoDTO> buscarPorId(@PathVariable Long id) {
        return estadoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - CREAR
    @PostMapping
    public ResponseEntity<EstadoDTO> crear(@RequestBody EstadoDTO dto) {

        EstadoDTO creado = estadoService.crear(dto);

        return ResponseEntity.ok(creado);
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<EstadoDTO> actualizar(
            @PathVariable Long id,
            @RequestBody EstadoDTO dto) {

        return estadoService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (estadoService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}