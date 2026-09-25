package com.practica.crud.service;

import com.practica.crud.model.Producto;
import com.practica.crud.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // GET - Obtener todos
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    // GET - Obtener por ID
    public Optional<Producto> buscarPorId(Long id) {
        return productoRepository.findById(id);
    }

    // POST - Guardar
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // DELETE - Eliminar
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    // Verificar si existe
    public boolean existeProducto(Long id) {
        return productoRepository.existsById(id);
    }
}