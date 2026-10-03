package com.practica.crud.service;

import com.practica.crud.dto.ConfigDTO;
import com.practica.crud.model.Config;
import com.practica.crud.repository.ConfigRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfigService {

    private final ConfigRepository configRepository;

    public ConfigService(ConfigRepository configRepository) {
        this.configRepository = configRepository;
    }

    // LISTAR TODOS
    public List<ConfigDTO> listar() {
        return configRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<ConfigDTO> buscarPorId(Long id) {
        return configRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public ConfigDTO crear(ConfigDTO dto) {

        Config config = new Config();

        config.setParametro(dto.getParametro());
        config.setValor(dto.getValor());
        config.setDescripcion(dto.getDescripcion());

        Config guardado = configRepository.save(config);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<ConfigDTO> actualizar(Long id, ConfigDTO dto) {

        return configRepository.findById(id)
                .map(config -> {

                    config.setParametro(dto.getParametro());
                    config.setValor(dto.getValor());
                    config.setDescripcion(dto.getDescripcion());

                    Config actualizado = configRepository.save(config);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!configRepository.existsById(id)) {
            return false;
        }

        configRepository.deleteById(id);

        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private ConfigDTO convertirADTO(Config config) {

        return new ConfigDTO(
                config.getId(),
                config.getParametro(),
                config.getValor(),
                config.getDescripcion()
        );
    }
}