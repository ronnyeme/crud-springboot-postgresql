package com.practica.crud.controller;

import com.practica.crud.dto.PasswDTO;
import com.practica.crud.service.PasswService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passw")
public class PasswController {

    private final PasswService passwService;

    public PasswController(PasswService passwService) {
        this.passwService = passwService;
    }

    // GET - LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<PasswDTO>> listar() {
        return ResponseEntity.ok(passwService.listar());
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<PasswDTO> buscarPorId(@PathVariable Long id) {
        return passwService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - CREAR
    @PostMapping
    public ResponseEntity<PasswDTO> crear(@RequestBody PasswDTO dto) {

        PasswDTO creado = passwService.crear(dto);

        return ResponseEntity.ok(creado);
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<PasswDTO> actualizar(
            @PathVariable Long id,
            @RequestBody PasswDTO dto) {

        return passwService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (passwService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}