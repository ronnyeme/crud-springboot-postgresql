package com.practica.crud.service;

import com.practica.crud.dto.EstadoDTO;
import com.practica.crud.model.Estado;
import com.practica.crud.repository.EstadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    private final EstadoRepository estadoRepository;

    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    // LISTAR TODOS
    public List<EstadoDTO> listar() {
        return estadoRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<EstadoDTO> buscarPorId(Long id) {
        return estadoRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public EstadoDTO crear(EstadoDTO dto) {

        Estado estado = new Estado();

        estado.setCodigo(dto.getCodigo());
        estado.setNombre(dto.getNombre());
        estado.setDescripcion(dto.getDescripcion());

        Estado guardado = estadoRepository.save(estado);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<EstadoDTO> actualizar(Long id, EstadoDTO dto) {

        return estadoRepository.findById(id)
                .map(estado -> {

                    estado.setCodigo(dto.getCodigo());
                    estado.setNombre(dto.getNombre());
                    estado.setDescripcion(dto.getDescripcion());

                    Estado actualizado = estadoRepository.save(estado);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!estadoRepository.existsById(id)) {
            return false;
        }

        estadoRepository.deleteById(id);

        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private EstadoDTO convertirADTO(Estado estado) {

        return new EstadoDTO(
                estado.getId(),
                estado.getCodigo(),
                estado.getNombre(),
                estado.getDescripcion()
        );
    }
}