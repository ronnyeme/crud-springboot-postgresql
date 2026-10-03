package com.practica.crud.controller;

import com.practica.crud.dto.EstEntDTO;
import com.practica.crud.service.EstEntService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/est-ent")
public class EstEntController {

    private final EstEntService estEntService;

    public EstEntController(EstEntService estEntService) {
        this.estEntService = estEntService;
    }

    // GET - LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<EstEntDTO>> listar() {
        return ResponseEntity.ok(estEntService.listar());
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<EstEntDTO> buscarPorId(@PathVariable Long id) {
        return estEntService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - CREAR
    @PostMapping
    public ResponseEntity<EstEntDTO> crear(@RequestBody EstEntDTO dto) {
        EstEntDTO creado = estEntService.crear(dto);
        return ResponseEntity.ok(creado);
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<EstEntDTO> actualizar(
            @PathVariable Long id,
            @RequestBody EstEntDTO dto) {

        return estEntService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (estEntService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}