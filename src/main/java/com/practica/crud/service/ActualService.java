package com.practica.crud.service;

import com.practica.crud.dto.ActualDTO;
import com.practica.crud.model.Actual;
import com.practica.crud.repository.ActualRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActualService {

    private final ActualRepository actualRepository;

    public ActualService(ActualRepository actualRepository) {
        this.actualRepository = actualRepository;
    }

    // LISTAR TODOS
    public List<ActualDTO> listar() {
        return actualRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<ActualDTO> buscarPorId(Long id) {
        return actualRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public ActualDTO crear(ActualDTO dto) {

        Actual actual = new Actual();

        actual.setCodigo(dto.getCodigo());
        actual.setDescripcion(dto.getDescripcion());
        actual.setEstado(dto.getEstado());

        Actual guardado = actualRepository.save(actual);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<ActualDTO> actualizar(Long id, ActualDTO dto) {

        return actualRepository.findById(id)
                .map(actual -> {

                    actual.setCodigo(dto.getCodigo());
                    actual.setDescripcion(dto.getDescripcion());
                    actual.setEstado(dto.getEstado());

                    Actual actualizado = actualRepository.save(actual);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!actualRepository.existsById(id)) {
            return false;
        }

        actualRepository.deleteById(id);
        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private ActualDTO convertirADTO(Actual actual) {

        return new ActualDTO(
                actual.getId(),
                actual.getCodigo(),
                actual.getDescripcion(),
                actual.getEstado()
        );
    }
}