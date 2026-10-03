package com.practica.crud.controller;

import com.practica.crud.dto.ConfigDTO;
import com.practica.crud.service.ConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/config")
public class ConfigController {

    private final ConfigService configService;

    public ConfigController(ConfigService configService) {
        this.configService = configService;
    }

    // GET - LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<ConfigDTO>> listar() {
        return ResponseEntity.ok(configService.listar());
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<ConfigDTO> buscarPorId(@PathVariable Long id) {

        return configService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - CREAR
    @PostMapping
    public ResponseEntity<ConfigDTO> crear(@RequestBody ConfigDTO dto) {

        ConfigDTO creado = configService.crear(dto);

        return ResponseEntity.ok(creado);
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<ConfigDTO> actualizar(
            @PathVariable Long id,
            @RequestBody ConfigDTO dto) {

        return configService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (configService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}