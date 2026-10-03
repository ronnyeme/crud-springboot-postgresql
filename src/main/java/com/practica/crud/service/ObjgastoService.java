package com.practica.crud.service;

import com.practica.crud.dto.ObjgastoDTO;
import com.practica.crud.model.Objgasto;
import com.practica.crud.repository.ObjgastoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjgastoService {

    private final ObjgastoRepository objgastoRepository;

    public ObjgastoService(ObjgastoRepository objgastoRepository) {
        this.objgastoRepository = objgastoRepository;
    }

    // LISTAR TODOS
    public List<ObjgastoDTO> listar() {
        return objgastoRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<ObjgastoDTO> buscarPorId(Long id) {
        return objgastoRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public ObjgastoDTO crear(ObjgastoDTO dto) {

        Objgasto objgasto = new Objgasto();

        objgasto.setCodigo(dto.getCodigo());
        objgasto.setNombre(dto.getNombre());
        objgasto.setDescripcion(dto.getDescripcion());

        Objgasto guardado = objgastoRepository.save(objgasto);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<ObjgastoDTO> actualizar(Long id, ObjgastoDTO dto) {

        return objgastoRepository.findById(id)
                .map(objgasto -> {

                    objgasto.setCodigo(dto.getCodigo());
                    objgasto.setNombre(dto.getNombre());
                    objgasto.setDescripcion(dto.getDescripcion());

                    Objgasto actualizado = objgastoRepository.save(objgasto);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!objgastoRepository.existsById(id)) {
            return false;
        }

        objgastoRepository.deleteById(id);

        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private ObjgastoDTO convertirADTO(Objgasto objgasto) {

        return new ObjgastoDTO(
                objgasto.getId(),
                objgasto.getCodigo(),
                objgasto.getNombre(),
                objgasto.getDescripcion()
        );
    }
}