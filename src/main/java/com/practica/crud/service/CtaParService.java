package com.practica.crud.service;

import com.practica.crud.dto.CtaParDTO;
import com.practica.crud.model.CtaPar;
import com.practica.crud.repository.CtaParRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CtaParService {

    private final CtaParRepository ctaParRepository;

    public CtaParService(CtaParRepository ctaParRepository) {
        this.ctaParRepository = ctaParRepository;
    }

    // LISTAR TODOS
    public List<CtaParDTO> listar() {
        return ctaParRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<CtaParDTO> buscarPorId(Long id) {
        return ctaParRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public CtaParDTO crear(CtaParDTO dto) {

        CtaPar ctaPar = new CtaPar();

        ctaPar.setCodigo(dto.getCodigo());
        ctaPar.setNombre(dto.getNombre());
        ctaPar.setDescripcion(dto.getDescripcion());

        CtaPar guardado = ctaParRepository.save(ctaPar);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<CtaParDTO> actualizar(Long id, CtaParDTO dto) {

        return ctaParRepository.findById(id)
                .map(ctaPar -> {

                    ctaPar.setCodigo(dto.getCodigo());
                    ctaPar.setNombre(dto.getNombre());
                    ctaPar.setDescripcion(dto.getDescripcion());

                    CtaPar actualizado = ctaParRepository.save(ctaPar);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!ctaParRepository.existsById(id)) {
            return false;
        }

        ctaParRepository.deleteById(id);

        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private CtaParDTO convertirADTO(CtaPar ctaPar) {

        return new CtaParDTO(
                ctaPar.getId(),
                ctaPar.getCodigo(),
                ctaPar.getNombre(),
                ctaPar.getDescripcion()
        );
    }
}