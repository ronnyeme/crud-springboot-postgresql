package com.practica.crud.controller;

import com.practica.crud.dto.TrasfeDTO;
import com.practica.crud.service.TrasfeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trasfe")
public class TrasfeController {

    private final TrasfeService trasfeService;

    public TrasfeController(TrasfeService trasfeService) {
        this.trasfeService = trasfeService;
    }

    // GET - LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<TrasfeDTO>> listar() {
        return ResponseEntity.ok(trasfeService.listar());
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<TrasfeDTO> buscarPorId(@PathVariable Long id) {
        return trasfeService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - CREAR
    @PostMapping
    public ResponseEntity<TrasfeDTO> crear(@RequestBody TrasfeDTO dto) {

        TrasfeDTO creado = trasfeService.crear(dto);

        return ResponseEntity.ok(creado);
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<TrasfeDTO> actualizar(
            @PathVariable Long id,
            @RequestBody TrasfeDTO dto) {

        return trasfeService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (trasfeService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}