package com.practica.crud.controller;

import com.practica.crud.dto.AuxiliarDTO;
import com.practica.crud.service.AuxiliarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auxiliar")
public class AuxiliarController {

    private final AuxiliarService auxiliarService;

    public AuxiliarController(AuxiliarService auxiliarService) {
        this.auxiliarService = auxiliarService;
    }

    // GET - LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<AuxiliarDTO>> listar() {
        return ResponseEntity.ok(auxiliarService.listar());
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<AuxiliarDTO> buscarPorId(@PathVariable Long id) {

        return auxiliarService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - CREAR
    @PostMapping
    public ResponseEntity<AuxiliarDTO> crear(@RequestBody AuxiliarDTO dto) {

        AuxiliarDTO creado = auxiliarService.crear(dto);

        return ResponseEntity.ok(creado);
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<AuxiliarDTO> actualizar(
            @PathVariable Long id,
            @RequestBody AuxiliarDTO dto) {

        return auxiliarService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (auxiliarService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}