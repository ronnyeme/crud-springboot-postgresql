package com.practica.crud.service;

import com.practica.crud.dto.MesDTO;
import com.practica.crud.model.Mes;
import com.practica.crud.repository.MesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesService {

    private final MesRepository mesRepository;

    public MesService(MesRepository mesRepository) {
        this.mesRepository = mesRepository;
    }

    // LISTAR TODOS
    public List<MesDTO> listar() {
        return mesRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<MesDTO> buscarPorId(Long id) {
        return mesRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public MesDTO crear(MesDTO dto) {

        Mes mes = new Mes();

        mes.setCodigo(dto.getCodigo());
        mes.setNombre(dto.getNombre());
        mes.setDescripcion(dto.getDescripcion());

        Mes guardado = mesRepository.save(mes);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<MesDTO> actualizar(Long id, MesDTO dto) {

        return mesRepository.findById(id)
                .map(mes -> {

                    mes.setCodigo(dto.getCodigo());
                    mes.setNombre(dto.getNombre());
                    mes.setDescripcion(dto.getDescripcion());

                    Mes actualizado = mesRepository.save(mes);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!mesRepository.existsById(id)) {
            return false;
        }

        mesRepository.deleteById(id);

        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private MesDTO convertirADTO(Mes mes) {

        return new MesDTO(
                mes.getId(),
                mes.getCodigo(),
                mes.getNombre(),
                mes.getDescripcion()
        );
    }
}