package com.practica.crud.controller;

import com.practica.crud.dto.CodcontDTO;
import com.practica.crud.service.CodcontService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/codcont")
public class CodcontController {

    private final CodcontService codcontService;

    public CodcontController(CodcontService codcontService) {
        this.codcontService = codcontService;
    }

    // GET - LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<CodcontDTO>> listar() {
        return ResponseEntity.ok(codcontService.listar());
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<CodcontDTO> buscarPorId(@PathVariable Long id) {

        return codcontService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - CREAR
    @PostMapping
    public ResponseEntity<CodcontDTO> crear(@RequestBody CodcontDTO dto) {

        CodcontDTO creado = codcontService.crear(dto);

        return ResponseEntity.ok(creado);
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<CodcontDTO> actualizar(
            @PathVariable Long id,
            @RequestBody CodcontDTO dto) {

        return codcontService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (codcontService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}