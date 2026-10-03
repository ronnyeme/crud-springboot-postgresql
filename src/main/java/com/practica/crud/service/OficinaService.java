package com.practica.crud.service;

import com.practica.crud.dto.OficinaDTO;
import com.practica.crud.model.Oficina;
import com.practica.crud.repository.OficinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OficinaService {

    private final OficinaRepository oficinaRepository;

    public OficinaService(OficinaRepository oficinaRepository) {
        this.oficinaRepository = oficinaRepository;
    }

    // LISTAR TODOS
    public List<OficinaDTO> listar() {
        return oficinaRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<OficinaDTO> buscarPorId(Long id) {
        return oficinaRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public OficinaDTO crear(OficinaDTO dto) {

        Oficina oficina = new Oficina();

        oficina.setCodigo(dto.getCodigo());
        oficina.setNombre(dto.getNombre());
        oficina.setDescripcion(dto.getDescripcion());

        Oficina guardado = oficinaRepository.save(oficina);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<OficinaDTO> actualizar(Long id, OficinaDTO dto) {

        return oficinaRepository.findById(id)
                .map(oficina -> {

                    oficina.setCodigo(dto.getCodigo());
                    oficina.setNombre(dto.getNombre());
                    oficina.setDescripcion(dto.getDescripcion());

                    Oficina actualizado = oficinaRepository.save(oficina);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!oficinaRepository.existsById(id)) {
            return false;
        }

        oficinaRepository.deleteById(id);

        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private OficinaDTO convertirADTO(Oficina oficina) {

        return new OficinaDTO(
                oficina.getId(),
                oficina.getCodigo(),
                oficina.getNombre(),
                oficina.getDescripcion()
        );
    }
}