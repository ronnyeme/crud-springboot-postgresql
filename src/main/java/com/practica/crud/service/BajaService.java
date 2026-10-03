package com.practica.crud.service;

import com.practica.crud.dto.BajaDTO;
import com.practica.crud.model.Baja;
import com.practica.crud.repository.BajaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BajaService {

    private final BajaRepository bajaRepository;

    public BajaService(BajaRepository bajaRepository) {
        this.bajaRepository = bajaRepository;
    }

    // LISTAR TODOS
    public List<BajaDTO> listar() {
        return bajaRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<BajaDTO> buscarPorId(Long id) {
        return bajaRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public BajaDTO crear(BajaDTO dto) {

        Baja baja = new Baja();

        baja.setCodigo(dto.getCodigo());
        baja.setMotivo(dto.getMotivo());
        baja.setFecha(dto.getFecha());

        Baja guardado = bajaRepository.save(baja);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<BajaDTO> actualizar(Long id, BajaDTO dto) {

        return bajaRepository.findById(id)
                .map(baja -> {

                    baja.setCodigo(dto.getCodigo());
                    baja.setMotivo(dto.getMotivo());
                    baja.setFecha(dto.getFecha());

                    Baja actualizado = bajaRepository.save(baja);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!bajaRepository.existsById(id)) {
            return false;
        }

        bajaRepository.deleteById(id);

        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private BajaDTO convertirADTO(Baja baja) {

        return new BajaDTO(
                baja.getId(),
                baja.getCodigo(),
                baja.getMotivo(),
                baja.getFecha()
        );
    }
}