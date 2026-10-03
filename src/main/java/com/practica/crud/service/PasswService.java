package com.practica.crud.service;

import com.practica.crud.dto.PasswDTO;
import com.practica.crud.model.Passw;
import com.practica.crud.repository.PasswRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasswService {

    private final PasswRepository passwRepository;

    public PasswService(PasswRepository passwRepository) {
        this.passwRepository = passwRepository;
    }

    // LISTAR TODOS
    public List<PasswDTO> listar() {
        return passwRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // BUSCAR POR ID
    public Optional<PasswDTO> buscarPorId(Long id) {
        return passwRepository.findById(id)
                .map(this::convertirADTO);
    }

    // CREAR
    public PasswDTO crear(PasswDTO dto) {

        Passw passw = new Passw();

        passw.setUsuario(dto.getUsuario());
        passw.setClave(dto.getClave());
        passw.setEstado(dto.getEstado());

        Passw guardado = passwRepository.save(passw);

        return convertirADTO(guardado);
    }

    // ACTUALIZAR
    public Optional<PasswDTO> actualizar(Long id, PasswDTO dto) {

        return passwRepository.findById(id)
                .map(passw -> {

                    passw.setUsuario(dto.getUsuario());
                    passw.setClave(dto.getClave());
                    passw.setEstado(dto.getEstado());

                    Passw actualizado = passwRepository.save(passw);

                    return convertirADTO(actualizado);
                });
    }

    // ELIMINAR
    public boolean eliminar(Long id) {

        if (!passwRepository.existsById(id)) {
            return false;
        }

        passwRepository.deleteById(id);

        return true;
    }

    // CONVERTIR ENTITY -> DTO
    private PasswDTO convertirADTO(Passw passw) {

        return new PasswDTO(
                passw.getId(),
                passw.getUsuario(),
                passw.getClave(),
                passw.getEstado()
        );
    }
}