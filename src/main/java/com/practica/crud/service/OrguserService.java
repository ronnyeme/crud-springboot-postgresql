package com.practica.crud.service;

import com.practica.crud.dto.OrguserDTO;
import com.practica.crud.model.Orguser;
import com.practica.crud.repository.OrguserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrguserService {

    private final OrguserRepository orguserRepository;

    public OrguserService(OrguserRepository orguserRepository) {
        this.orguserRepository = orguserRepository;
    }

    // LISTAR TODOS
    public List<OrguserDTO> listar() {
        return orguserRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<OrguserDTO> buscarPorId(Long id) {
        return orguserRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public OrguserDTO crear(OrguserDTO dto) {

        Orguser orguser = new Orguser();

        orguser.setCodigo(dto.getCodigo());
        orguser.setUsuario(dto.getUsuario());
        orguser.setDescripcion(dto.getDescripcion());

        Orguser guardado = orguserRepository.save(orguser);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<OrguserDTO> actualizar(Long id, OrguserDTO dto) {

        return orguserRepository.findById(id)
                .map(orguser -> {

                    orguser.setCodigo(dto.getCodigo());
                    orguser.setUsuario(dto.getUsuario());
                    orguser.setDescripcion(dto.getDescripcion());

                    Orguser actualizado = orguserRepository.save(orguser);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!orguserRepository.existsById(id)) {
            return false;
        }

        orguserRepository.deleteById(id);

        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private OrguserDTO convertirADTO(Orguser orguser) {

        return new OrguserDTO(
                orguser.getId(),
                orguser.getCodigo(),
                orguser.getUsuario(),
                orguser.getDescripcion()
        );
    }
}