package com.biblionet.biblionet.controller;

import com.biblionet.biblionet.model.Prestamo;
import com.biblionet.biblionet.services.PrestamoService;

// Importamos las anotaciones necesarias de Spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Anotamos la clase como un controlador de Spring
@RestController
// Definimos la ruta base para los endpoints de este controlador
@RequestMapping("/api/prestamoslib")

public class PrestamoController {

    // Inyectamos el servicio PrestamoService
    @Autowired
    private PrestamoService prestamoService;

    // EndPoint para obtener todos los prestamos
    @GetMapping
    public List<Prestamo> getAllPrestamo() {
        return prestamoService.getAllPrestamos();
    }

    // Endpoint para obtener un prestamo por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> getPrestamosById(@PathVariable Long id) {
        // Llamamos al servicio para obtener el prestamo
        Optional<Prestamo> prestamo = prestamoService.getPrestamoById(id);
        // Si el prestamo existe, devolvemos una respuesta OK con el prestamo
        // Si no, devolvemos una respuesta Not Found
        return prestamo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para crear un nuevo prestamo
    @PostMapping
    public ResponseEntity<Prestamo> createPrestamos(@RequestBody Prestamo prestamo) {
        // Llamamos al servicio para guardar el nuevo usuario
        Prestamo newPrestamo = prestamoService.savePrestamo(prestamo);
        // Devolvemos una respuesta Created con el nuevo usuario
        return new ResponseEntity<>(newPrestamo, HttpStatus.CREATED);
    }

    // Endpoint para eliminar un usuario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestamo(@PathVariable Long id) {
        // Llamamos al servicio para eliminar el usuario
        prestamoService.delPrestamo(id);
        // Devolvemos una respuesta No Content
        return ResponseEntity.noContent().build();
    }

      // Endpoint PUT para actualizar préstamo
      @PutMapping("/{id}")
      public ResponseEntity<Prestamo> updatePrestamo(@PathVariable Long id, @RequestBody Prestamo prestamo) {
          Optional<Prestamo> existingPrestamo = prestamoService.getPrestamoById(id);
  
          // Si el préstamo existe, lo actualizamos
          if (existingPrestamo.isPresent()) {
              Prestamo updatedPrestamo = existingPrestamo.get();
  
              // Actualizamos los campos del préstamo
              updatedPrestamo.setFechaPrestamo(prestamo.getFechaPrestamo());
              updatedPrestamo.setFechaDevolucion(prestamo.getFechaDevolucion());
              updatedPrestamo.setAlumno(prestamo.getAlumno());
              updatedPrestamo.setInventario(prestamo.getInventario());
  
              // Guardamos los cambios
              prestamoService.savePrestamo(updatedPrestamo);
  
              // Devolvemos el préstamo actualizado
              return ResponseEntity.ok(updatedPrestamo);
          } else {
              // Si no encontramos el préstamo con ese ID, devolvemos un error 404
              return ResponseEntity.notFound().build();
          }
      }

}
