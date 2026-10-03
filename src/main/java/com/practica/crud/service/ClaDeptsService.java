package com.practica.crud.service;

import com.practica.crud.dto.ClaDeptsDTO;
import com.practica.crud.model.ClaDepts;
import com.practica.crud.repository.ClaDeptsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaDeptsService {

    private final ClaDeptsRepository claDeptsRepository;

    public ClaDeptsService(ClaDeptsRepository claDeptsRepository) {
        this.claDeptsRepository = claDeptsRepository;
    }

    // LISTAR TODOS
    public List<ClaDeptsDTO> listar() {
        return claDeptsRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<ClaDeptsDTO> buscarPorId(Long id) {
        return claDeptsRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public ClaDeptsDTO crear(ClaDeptsDTO dto) {

        ClaDepts claDepts = new ClaDepts();

        claDepts.setCodigo(dto.getCodigo());
        claDepts.setNombre(dto.getNombre());
        claDepts.setDescripcion(dto.getDescripcion());

        ClaDepts guardado = claDeptsRepository.save(claDepts);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<ClaDeptsDTO> actualizar(Long id, ClaDeptsDTO dto) {

        return claDeptsRepository.findById(id)
                .map(claDepts -> {

                    claDepts.setCodigo(dto.getCodigo());
                    claDepts.setNombre(dto.getNombre());
                    claDepts.setDescripcion(dto.getDescripcion());

                    ClaDepts actualizado = claDeptsRepository.save(claDepts);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!claDeptsRepository.existsById(id)) {
            return false;
        }

        claDeptsRepository.deleteById(id);

        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private ClaDeptsDTO convertirADTO(ClaDepts claDepts) {

        return new ClaDeptsDTO(
                claDepts.getId(),
                claDepts.getCodigo(),
                claDepts.getNombre(),
                claDepts.getDescripcion()
        );
    }
}