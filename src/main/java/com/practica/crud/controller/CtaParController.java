package com.practica.crud.controller;

import com.practica.crud.dto.CtaParDTO;
import com.practica.crud.service.CtaParService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cta-par")
public class CtaParController {

    private final CtaParService ctaParService;

    public CtaParController(CtaParService ctaParService) {
        this.ctaParService = ctaParService;
    }

    // GET - LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<CtaParDTO>> listar() {
        return ResponseEntity.ok(ctaParService.listar());
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<CtaParDTO> buscarPorId(@PathVariable Long id) {
        return ctaParService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - CREAR
    @PostMapping
    public ResponseEntity<CtaParDTO> crear(@RequestBody CtaParDTO dto) {
        CtaParDTO creado = ctaParService.crear(dto);
        return ResponseEntity.ok(creado);
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<CtaParDTO> actualizar(
            @PathVariable Long id,
            @RequestBody CtaParDTO dto) {

        return ctaParService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (ctaParService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}