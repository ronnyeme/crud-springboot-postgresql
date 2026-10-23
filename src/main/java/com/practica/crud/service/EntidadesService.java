
package com.practica.crud.service;

import com.practica.crud.dto.EntidadesDTO;
import com.practica.crud.model.Entidades;
import com.practica.crud.repository.EntidadesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntidadesService {

    private final EntidadesRepository entidadesRepository;

    public EntidadesService(EntidadesRepository entidadesRepository) {
        this.entidadesRepository = entidadesRepository;
    }

    // GET - LISTAR TODAS LAS ENTIDADES
    public List<EntidadesDTO> listar() {
        return entidadesRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // GET - BUSCAR ENTIDAD POR ID
    public Optional<EntidadesDTO> buscarPorId(Long id) {
        return entidadesRepository.findById(id)
                .map(this::convertirADTO);
    }

    // POST - CREAR ENTIDAD
    public EntidadesDTO crear(EntidadesDTO dto) {

        Entidades entidad = new Entidades();

        copiarDatos(dto, entidad);

        Entidades guardado = entidadesRepository.save(entidad);

        return convertirADTO(guardado);
    }

    // PUT - ACTUALIZAR ENTIDAD
    public Optional<EntidadesDTO> actualizar(Long id, EntidadesDTO dto) {

        return entidadesRepository.findById(id)
                .map(entidad -> {

                    copiarDatos(dto, entidad);

                    Entidades actualizado = entidadesRepository.save(entidad);

                    return convertirADTO(actualizado);
                });
    }

    // DELETE - ELIMINAR ENTIDAD
    public boolean eliminar(Long id) {

        if (!entidadesRepository.existsById(id)) {
            return false;
        }

        entidadesRepository.deleteById(id);

        return true;
    }

    // COPIAR DATOS DEL DTO A LA ENTIDAD
    private void copiarDatos(EntidadesDTO dto, Entidades entidad) {

        entidad.setGestion(dto.getGestion());
        entidad.setEntidad(dto.getEntidad());
        entidad.setDescEnt(dto.getDescEnt());
        entidad.setSiglaEnt(dto.getSiglaEnt());
        entidad.setSectorEnt(dto.getSectorEnt());
        entidad.setSubsecEnt(dto.getSubsecEnt());
        entidad.setAreaEnt(dto.getAreaEnt());
        entidad.setSubareaent(dto.getSubareaent());
        entidad.setNivelInst(dto.getNivelInst());
    }

    // CONVERTIR ENTIDAD A DTO
    private EntidadesDTO convertirADTO(Entidades entidad) {

        return new EntidadesDTO(
                entidad.getId(),
                entidad.getGestion(),
                entidad.getEntidad(),
                entidad.getDescEnt(),
                entidad.getSiglaEnt(),
                entidad.getSectorEnt(),
                entidad.getSubsecEnt(),
                entidad.getAreaEnt(),
                entidad.getSubareaent(),
                entidad.getNivelInst()
        );
    }
}
