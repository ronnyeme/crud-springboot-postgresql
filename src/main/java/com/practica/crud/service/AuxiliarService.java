package com.practica.crud.service;

import com.practica.crud.dto.AuxiliarDTO;
import com.practica.crud.model.Auxiliar;
import com.practica.crud.repository.AuxiliarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuxiliarService {

    private final AuxiliarRepository auxiliarRepository;

    public AuxiliarService(AuxiliarRepository auxiliarRepository) {
        this.auxiliarRepository = auxiliarRepository;
    }

    // LISTAR TODOS
    public List<AuxiliarDTO> listar() {
        return auxiliarRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<AuxiliarDTO> buscarPorId(Long id) {
        return auxiliarRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public AuxiliarDTO crear(AuxiliarDTO dto) {

        Auxiliar auxiliar = new Auxiliar();

        auxiliar.setCodigo(dto.getCodigo());
        auxiliar.setNombre(dto.getNombre());
        auxiliar.setDescripcion(dto.getDescripcion());

        Auxiliar guardado = auxiliarRepository.save(auxiliar);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<AuxiliarDTO> actualizar(Long id, AuxiliarDTO dto) {

        return auxiliarRepository.findById(id)
                .map(auxiliar -> {

                    auxiliar.setCodigo(dto.getCodigo());
                    auxiliar.setNombre(dto.getNombre());
                    auxiliar.setDescripcion(dto.getDescripcion());

                    Auxiliar actualizado = auxiliarRepository.save(auxiliar);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!auxiliarRepository.existsById(id)) {
            return false;
        }

        auxiliarRepository.deleteById(id);

        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private AuxiliarDTO convertirADTO(Auxiliar auxiliar) {

        return new AuxiliarDTO(
                auxiliar.getId(),
                auxiliar.getCodigo(),
                auxiliar.getNombre(),
                auxiliar.getDescripcion()
        );
    }
}