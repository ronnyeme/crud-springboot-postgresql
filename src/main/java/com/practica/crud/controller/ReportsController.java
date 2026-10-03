package com.practica.crud.controller;

import com.practica.crud.dto.ReportsDTO;
import com.practica.crud.service.ReportsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportsController {

    private final ReportsService reportsService;

    public ReportsController(ReportsService reportsService) {
        this.reportsService = reportsService;
    }

    // GET - LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<ReportsDTO>> listar() {
        return ResponseEntity.ok(reportsService.listar());
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<ReportsDTO> buscarPorId(@PathVariable Long id) {
        return reportsService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - CREAR
    @PostMapping
    public ResponseEntity<ReportsDTO> crear(@RequestBody ReportsDTO dto) {

        ReportsDTO creado = reportsService.crear(dto);

        return ResponseEntity.ok(creado);
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<ReportsDTO> actualizar(
            @PathVariable Long id,
            @RequestBody ReportsDTO dto) {

        return reportsService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (reportsService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}