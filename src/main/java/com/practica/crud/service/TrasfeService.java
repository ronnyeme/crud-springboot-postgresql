package com.practica.crud.service;

import com.practica.crud.dto.TrasfeDTO;
import com.practica.crud.model.Trasfe;
import com.practica.crud.repository.TrasfeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrasfeService {

    private final TrasfeRepository trasfeRepository;

    public TrasfeService(TrasfeRepository trasfeRepository) {
        this.trasfeRepository = trasfeRepository;
    }

    // LISTAR TODOS
    public List<TrasfeDTO> listar() {
        return trasfeRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<TrasfeDTO> buscarPorId(Long id) {
        return trasfeRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public TrasfeDTO crear(TrasfeDTO dto) {

        Trasfe trasfe = new Trasfe();

        trasfe.setCodigo(dto.getCodigo());
        trasfe.setDescripcion(dto.getDescripcion());
        trasfe.setEstado(dto.getEstado());

        Trasfe guardado = trasfeRepository.save(trasfe);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<TrasfeDTO> actualizar(Long id, TrasfeDTO dto) {

        return trasfeRepository.findById(id)
                .map(trasfe -> {

                    trasfe.setCodigo(dto.getCodigo());
                    trasfe.setDescripcion(dto.getDescripcion());
                    trasfe.setEstado(dto.getEstado());

                    Trasfe actualizado = trasfeRepository.save(trasfe);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!trasfeRepository.existsById(id)) {
            return false;
        }

        trasfeRepository.deleteById(id);

        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private TrasfeDTO convertirADTO(Trasfe trasfe) {

        return new TrasfeDTO(
                trasfe.getId(),
                trasfe.getCodigo(),
                trasfe.getDescripcion(),
                trasfe.getEstado()
        );
    }
}