package com.practica.crud.service;

import com.practica.crud.dto.CodcontDTO;
import com.practica.crud.model.Codcont;
import com.practica.crud.repository.CodcontRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CodcontService {

    private final CodcontRepository codcontRepository;

    public CodcontService(CodcontRepository codcontRepository) {
        this.codcontRepository = codcontRepository;
    }

    // LISTAR TODOS
    public List<CodcontDTO> listar() {
        return codcontRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<CodcontDTO> buscarPorId(Long id) {
        return codcontRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public CodcontDTO crear(CodcontDTO dto) {

        Codcont codcont = new Codcont();

        codcont.setCodigo(dto.getCodigo());
        codcont.setNombre(dto.getNombre());
        codcont.setDescripcion(dto.getDescripcion());

        Codcont guardado = codcontRepository.save(codcont);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<CodcontDTO> actualizar(Long id, CodcontDTO dto) {

        return codcontRepository.findById(id)
                .map(codcont -> {

                    codcont.setCodigo(dto.getCodigo());
                    codcont.setNombre(dto.getNombre());
                    codcont.setDescripcion(dto.getDescripcion());

                    Codcont actualizado = codcontRepository.save(codcont);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!codcontRepository.existsById(id)) {
            return false;
        }

        codcontRepository.deleteById(id);

        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private CodcontDTO convertirADTO(Codcont codcont) {

        return new CodcontDTO(
                codcont.getId(),
                codcont.getCodigo(),
                codcont.getNombre(),
                codcont.getDescripcion()
        );
    }
}