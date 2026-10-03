package com.practica.crud.controller;

import com.practica.crud.dto.BajasDTO;
import com.practica.crud.service.BajasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bajas")
public class BajasController {

    private final BajasService bajasService;

    public BajasController(BajasService bajasService) {
        this.bajasService = bajasService;
    }

    // GET - LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<BajasDTO>> listar() {
        return ResponseEntity.ok(bajasService.listar());
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<BajasDTO> buscarPorId(@PathVariable Long id) {

        return bajasService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - CREAR
    @PostMapping
    public ResponseEntity<BajasDTO> crear(@RequestBody BajasDTO dto) {

        BajasDTO creado = bajasService.crear(dto);

        return ResponseEntity.ok(creado);
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<BajasDTO> actualizar(
            @PathVariable Long id,
            @RequestBody BajasDTO dto) {

        return bajasService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (bajasService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}