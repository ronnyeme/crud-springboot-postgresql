package com.practica.crud.controller;

import com.practica.crud.dto.MesDTO;
import com.practica.crud.service.MesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mes")
public class MesController {

    private final MesService mesService;

    public MesController(MesService mesService) {
        this.mesService = mesService;
    }

    // GET - LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<MesDTO>> listar() {
        return ResponseEntity.ok(mesService.listar());
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<MesDTO> buscarPorId(@PathVariable Long id) {
        return mesService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - CREAR
    @PostMapping
    public ResponseEntity<MesDTO> crear(@RequestBody MesDTO dto) {

        MesDTO creado = mesService.crear(dto);

        return ResponseEntity.ok(creado);
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<MesDTO> actualizar(
            @PathVariable Long id,
            @RequestBody MesDTO dto) {

        return mesService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (mesService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}