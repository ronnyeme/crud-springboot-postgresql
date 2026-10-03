package com.practica.crud.controller;

import com.practica.crud.dto.ClaDeptsDTO;
import com.practica.crud.service.ClaDeptsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cla-depts")
public class ClaDeptsController {

    private final ClaDeptsService claDeptsService;

    public ClaDeptsController(ClaDeptsService claDeptsService) {
        this.claDeptsService = claDeptsService;
    }

    // GET - LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<ClaDeptsDTO>> listar() {
        return ResponseEntity.ok(claDeptsService.listar());
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<ClaDeptsDTO> buscarPorId(@PathVariable Long id) {

        return claDeptsService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - CREAR
    @PostMapping
    public ResponseEntity<ClaDeptsDTO> crear(@RequestBody ClaDeptsDTO dto) {

        ClaDeptsDTO creado = claDeptsService.crear(dto);

        return ResponseEntity.ok(creado);
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<ClaDeptsDTO> actualizar(
            @PathVariable Long id,
            @RequestBody ClaDeptsDTO dto) {

        return claDeptsService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (claDeptsService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}