package com.practica.crud.controller;

import com.practica.crud.dto.RespDTO;
import com.practica.crud.service.RespService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resp")
public class RespController {

    private final RespService respService;

    public RespController(RespService respService) {
        this.respService = respService;
    }

    // GET - LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<RespDTO>> listar() {
        return ResponseEntity.ok(respService.listar());
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<RespDTO> buscarPorId(@PathVariable Long id) {
        return respService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - CREAR
    @PostMapping
    public ResponseEntity<RespDTO> crear(@RequestBody RespDTO dto) {

        RespDTO creado = respService.crear(dto);

        return ResponseEntity.ok(creado);
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<RespDTO> actualizar(
            @PathVariable Long id,
            @RequestBody RespDTO dto) {

        return respService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (respService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}