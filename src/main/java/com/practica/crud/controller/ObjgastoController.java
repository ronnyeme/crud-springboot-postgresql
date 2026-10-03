package com.practica.crud.controller;

import com.practica.crud.dto.ObjgastoDTO;
import com.practica.crud.service.ObjgastoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objgasto")
public class ObjgastoController {

    private final ObjgastoService objgastoService;

    public ObjgastoController(ObjgastoService objgastoService) {
        this.objgastoService = objgastoService;
    }

    // GET - LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<ObjgastoDTO>> listar() {
        return ResponseEntity.ok(objgastoService.listar());
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<ObjgastoDTO> buscarPorId(@PathVariable Long id) {
        return objgastoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - CREAR
    @PostMapping
    public ResponseEntity<ObjgastoDTO> crear(@RequestBody ObjgastoDTO dto) {

        ObjgastoDTO creado = objgastoService.crear(dto);

        return ResponseEntity.ok(creado);
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<ObjgastoDTO> actualizar(
            @PathVariable Long id,
            @RequestBody ObjgastoDTO dto) {

        return objgastoService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (objgastoService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}