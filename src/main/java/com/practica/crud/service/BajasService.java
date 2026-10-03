package com.practica.crud.service;

import com.practica.crud.dto.BajasDTO;
import com.practica.crud.model.Bajas;
import com.practica.crud.repository.BajasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BajasService {

    private final BajasRepository bajasRepository;

    public BajasService(BajasRepository bajasRepository) {
        this.bajasRepository = bajasRepository;
    }

    // LISTAR TODOS
    public List<BajasDTO> listar() {
        return bajasRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<BajasDTO> buscarPorId(Long id) {
        return bajasRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public BajasDTO crear(BajasDTO dto) {

        Bajas bajas = new Bajas();

        bajas.setCodigo(dto.getCodigo());
        bajas.setDescripcion(dto.getDescripcion());
        bajas.setEstado(dto.getEstado());

        Bajas guardado = bajasRepository.save(bajas);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<BajasDTO> actualizar(Long id, BajasDTO dto) {

        return bajasRepository.findById(id)
                .map(bajas -> {

                    bajas.setCodigo(dto.getCodigo());
                    bajas.setDescripcion(dto.getDescripcion());
                    bajas.setEstado(dto.getEstado());

                    Bajas actualizado = bajasRepository.save(bajas);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!bajasRepository.existsById(id)) {
            return false;
        }

        bajasRepository.deleteById(id);

        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private BajasDTO convertirADTO(Bajas bajas) {

        return new BajasDTO(
                bajas.getId(),
                bajas.getCodigo(),
                bajas.getDescripcion(),
                bajas.getEstado()
        );
    }
}