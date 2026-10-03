package com.practica.crud.service;

import com.practica.crud.dto.BackupsDTO;
import com.practica.crud.model.Backups;
import com.practica.crud.repository.BackupsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BackupsService {

    private final BackupsRepository backupsRepository;

    public BackupsService(BackupsRepository backupsRepository) {
        this.backupsRepository = backupsRepository;
    }

    // LISTAR TODOS
    public List<BackupsDTO> listar() {
        return backupsRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<BackupsDTO> buscarPorId(Long id) {
        return backupsRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public BackupsDTO crear(BackupsDTO dto) {

        Backups backups = new Backups();

        backups.setNombre(dto.getNombre());
        backups.setUbicacion(dto.getUbicacion());
        backups.setFecha(dto.getFecha());

        Backups guardado = backupsRepository.save(backups);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<BackupsDTO> actualizar(Long id, BackupsDTO dto) {

        return backupsRepository.findById(id)
                .map(backups -> {

                    backups.setNombre(dto.getNombre());
                    backups.setUbicacion(dto.getUbicacion());
                    backups.setFecha(dto.getFecha());

                    Backups actualizado = backupsRepository.save(backups);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!backupsRepository.existsById(id)) {
            return false;
        }

        backupsRepository.deleteById(id);

        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private BackupsDTO convertirADTO(Backups backups) {

        return new BackupsDTO(
                backups.getId(),
                backups.getNombre(),
                backups.getUbicacion(),
                backups.getFecha()
        );
    }
}