package com.practica.crud.controller;

import com.practica.crud.dto.DataDTO;
import com.practica.crud.service.DataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class DataController {

    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    // GET - LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<DataDTO>> listar() {
        return ResponseEntity.ok(dataService.listar());
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<DataDTO> buscarPorId(@PathVariable Long id) {

        return dataService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - CREAR
    @PostMapping
    public ResponseEntity<DataDTO> crear(@RequestBody DataDTO dto) {

        DataDTO creado = dataService.crear(dto);

        return ResponseEntity.ok(creado);
    }

    // PUT - ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<DataDTO> actualizar(
            @PathVariable Long id,
            @RequestBody DataDTO dto) {

        return dataService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (dataService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}