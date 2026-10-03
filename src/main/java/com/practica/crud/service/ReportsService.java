package com.practica.crud.service;

import com.practica.crud.dto.ReportsDTO;
import com.practica.crud.model.Reports;
import com.practica.crud.repository.ReportsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportsService {

    private final ReportsRepository reportsRepository;

    public ReportsService(ReportsRepository reportsRepository) {
        this.reportsRepository = reportsRepository;
    }

    // LISTAR TODOS
    public List<ReportsDTO> listar() {
        return reportsRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<ReportsDTO> buscarPorId(Long id) {
        return reportsRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public ReportsDTO crear(ReportsDTO dto) {

        Reports reports = new Reports();

        reports.setNombre(dto.getNombre());
        reports.setDescripcion(dto.getDescripcion());
        reports.setTipo(dto.getTipo());

        Reports guardado = reportsRepository.save(reports);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<ReportsDTO> actualizar(Long id, ReportsDTO dto) {

        return reportsRepository.findById(id)
                .map(reports -> {

                    reports.setNombre(dto.getNombre());
                    reports.setDescripcion(dto.getDescripcion());
                    reports.setTipo(dto.getTipo());

                    Reports actualizado = reportsRepository.save(reports);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!reportsRepository.existsById(id)) {
            return false;
        }

        reportsRepository.deleteById(id);

        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private ReportsDTO convertirADTO(Reports reports) {

        return new ReportsDTO(
                reports.getId(),
                reports.getNombre(),
                reports.getDescripcion(),
                reports.getTipo()
        );
    }
}