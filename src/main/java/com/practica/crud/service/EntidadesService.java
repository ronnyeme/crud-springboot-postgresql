package com.practica.crud.service;

import com.practica.crud.dto.EntidadesDTO;
import com.practica.crud.model.Entidades;
import com.practica.crud.repository.EntidadesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntidadesService {

    private final EntidadesRepository entidadesRepository;

    public EntidadesService(EntidadesRepository entidadesRepository) {
        this.entidadesRepository = entidadesRepository;
    }

    // LISTAR TODOS
    public List<EntidadesDTO> listar() {
        return entidadesRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<EntidadesDTO> buscarPorId(Long id) {
        return entidadesRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public EntidadesDTO crear(EntidadesDTO dto) {

        Entidades entidades = new Entidades();

        entidades.setCodigo(dto.getCodigo());
        entidades.setNombre(dto.getNombre());
        entidades.setDescripcion(dto.getDescripcion());

        Entidades guardado = entidadesRepository.save(entidades);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<EntidadesDTO> actualizar(Long id, EntidadesDTO dto) {

        return entidadesRepository.findById(id)
                .map(entidades -> {

                    entidades.setCodigo(dto.getCodigo());
                    entidades.setNombre(dto.getNombre());
                    entidades.setDescripcion(dto.getDescripcion());

                    Entidades actualizado = entidadesRepository.save(entidades);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!entidadesRepository.existsById(id)) {
            return false;
        }

        entidadesRepository.deleteById(id);

        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private EntidadesDTO convertirADTO(Entidades entidades) {

        return new EntidadesDTO(
                entidades.getId(),
                entidades.getCodigo(),
                entidades.getNombre(),
                entidades.getDescripcion()
        );
    }
}