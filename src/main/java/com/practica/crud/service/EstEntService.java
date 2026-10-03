package com.practica.crud.service;

import com.practica.crud.dto.EstEntDTO;
import com.practica.crud.model.EstEnt;
import com.practica.crud.repository.EstEntRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstEntService {

    private final EstEntRepository estEntRepository;

    public EstEntService(EstEntRepository estEntRepository) {
        this.estEntRepository = estEntRepository;
    }

    // LISTAR TODOS
    public List<EstEntDTO> listar() {
        return estEntRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<EstEntDTO> buscarPorId(Long id) {
        return estEntRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public EstEntDTO crear(EstEntDTO dto) {

        EstEnt estEnt = new EstEnt();

        estEnt.setCodigo(dto.getCodigo());
        estEnt.setNombre(dto.getNombre());
        estEnt.setEstado(dto.getEstado());

        EstEnt guardado = estEntRepository.save(estEnt);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<EstEntDTO> actualizar(Long id, EstEntDTO dto) {

        return estEntRepository.findById(id)
                .map(estEnt -> {

                    estEnt.setCodigo(dto.getCodigo());
                    estEnt.setNombre(dto.getNombre());
                    estEnt.setEstado(dto.getEstado());

                    EstEnt actualizado = estEntRepository.save(estEnt);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!estEntRepository.existsById(id)) {
            return false;
        }

        estEntRepository.deleteById(id);

        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private EstEntDTO convertirADTO(EstEnt estEnt) {

        return new EstEntDTO(
                estEnt.getId(),
                estEnt.getCodigo(),
                estEnt.getNombre(),
                estEnt.getEstado()
        );
    }
}