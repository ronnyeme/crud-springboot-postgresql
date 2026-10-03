package com.practica.crud.service;

import com.practica.crud.dto.RevalDTO;
import com.practica.crud.model.Reval;
import com.practica.crud.repository.RevalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RevalService {

    private final RevalRepository revalRepository;

    public RevalService(RevalRepository revalRepository) {
        this.revalRepository = revalRepository;
    }

    // LISTAR TODOS
    public List<RevalDTO> listar() {
        return revalRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<RevalDTO> buscarPorId(Long id) {
        return revalRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public RevalDTO crear(RevalDTO dto) {

        Reval reval = new Reval();

        reval.setCodigo(dto.getCodigo());
        reval.setDescripcion(dto.getDescripcion());
        reval.setEstado(dto.getEstado());

        Reval guardado = revalRepository.save(reval);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<RevalDTO> actualizar(Long id, RevalDTO dto) {

        return revalRepository.findById(id)
                .map(reval -> {

                    reval.setCodigo(dto.getCodigo());
                    reval.setDescripcion(dto.getDescripcion());
                    reval.setEstado(dto.getEstado());

                    Reval actualizado = revalRepository.save(reval);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!revalRepository.existsById(id)) {
            return false;
        }

        revalRepository.deleteById(id);

        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private RevalDTO convertirADTO(Reval reval) {

        return new RevalDTO(
                reval.getId(),
                reval.getCodigo(),
                reval.getDescripcion(),
                reval.getEstado()
        );
    }
}