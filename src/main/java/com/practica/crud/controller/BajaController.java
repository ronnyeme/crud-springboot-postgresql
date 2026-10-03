package com.practica.crud.controller;

import com.practica.crud.dto.BajaDTO;
import com.practica.crud.service.BajaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/baja")
public class BajaController {

    private final BajaService bajaService;

    public BajaController(BajaService bajaService) {
        this.bajaService = bajaService;
    }

    // GET - LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<BajaDTO>> listar() {
        return ResponseEntity.ok(bajaService.listar());
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<BajaDTO> buscarPorId(@PathVariable Long id) {

        return bajaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - CREAR
    @PostMapping
    public ResponseEntity<BajaDTO> crear(@RequestBody BajaDTO dto) {

        BajaDTO creado = bajaService.crear(dto);

        return ResponseEntity.ok(creado);
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<BajaDTO> actualizar(
            @PathVariable Long id,
            @RequestBody BajaDTO dto) {

        return bajaService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (bajaService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}