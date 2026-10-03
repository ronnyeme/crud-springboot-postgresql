package com.practica.crud.service;

import com.practica.crud.dto.RespDTO;
import com.practica.crud.model.Resp;
import com.practica.crud.repository.RespRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespService {

    private final RespRepository respRepository;

    public RespService(RespRepository respRepository) {
        this.respRepository = respRepository;
    }

    // LISTAR TODOS
    public List<RespDTO> listar() {
        return respRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<RespDTO> buscarPorId(Long id) {
        return respRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public RespDTO crear(RespDTO dto) {

        Resp resp = new Resp();

        resp.setCodigo(dto.getCodigo());
        resp.setNombre(dto.getNombre());
        resp.setDescripcion(dto.getDescripcion());

        Resp guardado = respRepository.save(resp);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<RespDTO> actualizar(Long id, RespDTO dto) {

        return respRepository.findById(id)
                .map(resp -> {

                    resp.setCodigo(dto.getCodigo());
                    resp.setNombre(dto.getNombre());
                    resp.setDescripcion(dto.getDescripcion());

                    Resp actualizado = respRepository.save(resp);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!respRepository.existsById(id)) {
            return false;
        }

        respRepository.deleteById(id);

        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private RespDTO convertirADTO(Resp resp) {

        return new RespDTO(
                resp.getId(),
                resp.getCodigo(),
                resp.getNombre(),
                resp.getDescripcion()
        );
    }
}