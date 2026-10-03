package com.practica.crud.service;

import com.practica.crud.dto.OrganismoFinDTO;
import com.practica.crud.model.OrganismoFin;
import com.practica.crud.repository.OrganismoFinRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganismoFinService {

    private final OrganismoFinRepository organismoFinRepository;

    public OrganismoFinService(OrganismoFinRepository organismoFinRepository) {
        this.organismoFinRepository = organismoFinRepository;
    }

    // LISTAR TODOS
    public List<OrganismoFinDTO> listar() {
        return organismoFinRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<OrganismoFinDTO> buscarPorId(Long id) {
        return organismoFinRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public OrganismoFinDTO crear(OrganismoFinDTO dto) {

        OrganismoFin organismoFin = new OrganismoFin();

        organismoFin.setCodigo(dto.getCodigo());
        organismoFin.setNombre(dto.getNombre());
        organismoFin.setDescripcion(dto.getDescripcion());

        OrganismoFin guardado = organismoFinRepository.save(organismoFin);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<OrganismoFinDTO> actualizar(Long id, OrganismoFinDTO dto) {

        return organismoFinRepository.findById(id)
                .map(organismoFin -> {

                    organismoFin.setCodigo(dto.getCodigo());
                    organismoFin.setNombre(dto.getNombre());
                    organismoFin.setDescripcion(dto.getDescripcion());

                    OrganismoFin actualizado =
                            organismoFinRepository.save(organismoFin);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!organismoFinRepository.existsById(id)) {
            return false;
        }

        organismoFinRepository.deleteById(id);

        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private OrganismoFinDTO convertirADTO(OrganismoFin organismoFin) {

        return new OrganismoFinDTO(
                organismoFin.getId(),
                organismoFin.getCodigo(),
                organismoFin.getNombre(),
                organismoFin.getDescripcion()
        );
    }
}