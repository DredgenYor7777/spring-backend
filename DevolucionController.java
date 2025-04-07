package com.biblionet.biblionet.controller;

import com.biblionet.biblionet.model.Alumno;
// Importamos la clase Usuario que representa la entidad
import com.biblionet.biblionet.model.Devolucion;

// Importamos el servicio UsuarioService que contiene la lógica de negocio
import com.biblionet.biblionet.services.DevolucionService;

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
@RequestMapping("/api/devolucionlib")

public class DevolucionController {

    // Inyectamos el servicio UsuarioService
    @Autowired
    private DevolucionService devolucionService;

    // EndPoint para obtener todos los usuarios
    @GetMapping
    public List<Devolucion> getAllDevolucion() {
        return devolucionService.getAllDevolucions();
    }

    // Endpoint para obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Devolucion> getDevolucionById(@PathVariable Long id) {
        // Llamamos al servicio para obtener el usuario
        Optional<Devolucion> devolucion = devolucionService.getDevolucionsById(id);
        // Si el usuario existe, devolvemos una respuesta OK con el usuario
        // Si no, devolvemos una respuesta Not Found
        return devolucion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para crear un nuevo usuario
    @PostMapping
    public ResponseEntity<Devolucion> createDevolucion(@RequestBody Devolucion devolucion) {
        // Llamamos al servicio para guardar el nuevo usuario
        Devolucion newDevolucion = devolucionService.saveDevolucions(devolucion);
        // Devolvemos una respuesta Created con el nuevo usuario
        return new ResponseEntity<>(newDevolucion, HttpStatus.CREATED);
    }

    // Endpoint para eliminar un usuario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevolucion(@PathVariable Long id) {
        // Llamamos al servicio para eliminar el usuario
        devolucionService.deleteDevolucions(id);
        // Devolvemos una respuesta No Content
        return ResponseEntity.noContent().build();
    }

     // Endpoint para actualizar una devolución por su ID
@PutMapping("/{id}")
public ResponseEntity<Devolucion> updateDevolucion(@PathVariable Long id, @RequestBody Devolucion devolucion) {
    // Buscar la devolución por su id
    Optional<Devolucion> existingDevolucion = devolucionService.getDevolucionsById(id);

    // Si la devolución existe, la actualizamos
    if (existingDevolucion.isPresent()) {
        Devolucion updatedDevolucion = existingDevolucion.get();

        // Actualizamos los campos de la devolución
        updatedDevolucion.setAlumno(devolucion.getAlumno()); // Relación con Alumno
        updatedDevolucion.setInventario(devolucion.getInventario()); // Relación con Inventario

        // Guardamos los cambios
        devolucionService.saveDevolucions(updatedDevolucion);

        // Devolvemos la devolución actualizada
        return ResponseEntity.ok(updatedDevolucion);
    } else {
        // Si no encontramos la devolución con ese id, devolvemos un error 404
        return ResponseEntity.notFound().build();
    }
}


}
