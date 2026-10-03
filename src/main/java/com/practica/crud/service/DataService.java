package com.practica.crud.service;

import com.practica.crud.dto.DataDTO;
import com.practica.crud.model.Data;
import com.practica.crud.repository.DataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataService {

    private final DataRepository dataRepository;

    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    // LISTAR TODOS
    public List<DataDTO> listar() {
        return dataRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<DataDTO> buscarPorId(Long id) {
        return dataRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public DataDTO crear(DataDTO dto) {

        Data data = new Data();

        data.setCodigo(dto.getCodigo());
        data.setValor(dto.getValor());
        data.setDescripcion(dto.getDescripcion());

        Data guardado = dataRepository.save(data);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<DataDTO> actualizar(Long id, DataDTO dto) {

        return dataRepository.findById(id)
                .map(data -> {

                    data.setCodigo(dto.getCodigo());
                    data.setValor(dto.getValor());
                    data.setDescripcion(dto.getDescripcion());

                    Data actualizado = dataRepository.save(data);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!dataRepository.existsById(id)) {
            return false;
        }

        dataRepository.deleteById(id);

        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private DataDTO convertirADTO(Data data) {

        return new DataDTO(
                data.getId(),
                data.getCodigo(),
                data.getValor(),
                data.getDescripcion()
        );
    }
}
