package com.biblionet.biblionet.services;

// Importamos la clase Login que representa la entidad
import com.biblionet.biblionet.model.Prestamo;

// Importamos el repositorio UsuarioRepository que interactúa con la base de datos
import com.biblionet.biblionet.repository.PrestamoRepository;

// Importamos las anotaciones necesarias de Spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Anotamos la clase como un servicio de Spring
@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    // Método para obtener todos los prestamos
    public List<Prestamo> getAllPrestamos() {
        // Utiliza el repositorio para encontrar y devolver todos los prestamos
        return prestamoRepository.findAll();
    }

    // Método para obtener un prestamo por su ID
    public Optional<Prestamo> getPrestamoById(Long id) {
        // Utiliza el repositorio para encontrar un prestamo por su ID
        return prestamoRepository.findById(id);
    }

    // Método para guardar un nuevo prestamo o actualizar uno existente
    public Prestamo savePrestamo(Prestamo prestamo) {
        // Utiliza el repositorio para guardar el prestamo
        return prestamoRepository.save(prestamo);
    }

    // Método para eliminar un prestamo por su ID
    public void delPrestamo(Long id) {
        // Utiliza el repositorio para eliminar el prestamo por su ID
        prestamoRepository.deleteById(id);
    }

}
