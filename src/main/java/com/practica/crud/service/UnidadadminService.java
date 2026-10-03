package com.practica.crud.service;

import com.practica.crud.dto.UnidadadminDTO;
import com.practica.crud.model.Unidadadmin;
import com.practica.crud.repository.UnidadadminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadadminService {

    private final UnidadadminRepository unidadadminRepository;

    public UnidadadminService(UnidadadminRepository unidadadminRepository) {
        this.unidadadminRepository = unidadadminRepository;
    }

    // LISTAR TODOS
    public List<UnidadadminDTO> listar() {
        return unidadadminRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<UnidadadminDTO> buscarPorId(Long id) {
        return unidadadminRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public UnidadadminDTO crear(UnidadadminDTO dto) {

        Unidadadmin unidadadmin = new Unidadadmin();

        unidadadmin.setCodigo(dto.getCodigo());
        unidadadmin.setNombre(dto.getNombre());
        unidadadmin.setDescripcion(dto.getDescripcion());

        Unidadadmin guardado = unidadadminRepository.save(unidadadmin);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<UnidadadminDTO> actualizar(Long id, UnidadadminDTO dto) {

        return unidadadminRepository.findById(id)
                .map(unidadadmin -> {

                    unidadadmin.setCodigo(dto.getCodigo());
                    unidadadmin.setNombre(dto.getNombre());
                    unidadadmin.setDescripcion(dto.getDescripcion());

                    Unidadadmin actualizado =
                            unidadadminRepository.save(unidadadmin);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!unidadadminRepository.existsById(id)) {
            return false;
        }

        unidadadminRepository.deleteById(id);

        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private UnidadadminDTO convertirADTO(Unidadadmin unidadadmin) {

        return new UnidadadminDTO(
                unidadadmin.getId(),
                unidadadmin.getCodigo(),
                unidadadmin.getNombre(),
                unidadadmin.getDescripcion()
        );
    }
}