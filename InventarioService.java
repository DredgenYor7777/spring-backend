package com.biblionet.biblionet.services;


import com.biblionet.biblionet.model.Inventario;
// Importamos el repositorio UsuarioRepository que interactúa con la base de datos
import com.biblionet.biblionet.repository.InventarioRepository;

// Importamos las anotaciones necesarias de Spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Anotamos la clase como un servicio de Spring
@Service
public class InventarioService {

    @Autowired
    private InventarioRepository invRepository;

    // Método para obtener todo el inventario
    public List<Inventario> getAllInventory() {
        // Utiliza el repositorio para encontrar y devolver todos el inventario
        return invRepository.findAll();
    }

    // Método para obtener un usuario por su ID
    public Optional<Inventario> getInventoryById(Long id) {
        // Utiliza el repositorio para encontrar un inventario por su ID
        return invRepository.findById(id);
    }

    // Método para guardar un nuevo usuario o actualizar uno existente
    public Inventario saveInventory(Inventario inventario) {
        // Utiliza el repositorio para guardar el usuario
        return invRepository.save(inventario);
    }

    // Método para eliminar un usuario por su ID
    public void deleteInventory(Long id) {
        // Utiliza el repositorio para eliminar el usuario por su ID
        invRepository.deleteById(id);
    }

}
