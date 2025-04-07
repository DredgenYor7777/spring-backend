package com.biblionet.biblionet.controller;

// Importamos la clase Usuario que representa la entidad
import com.biblionet.biblionet.model.Alumno;

// Importamos el servicio UsuarioService que contiene la lógica de negocio
import com.biblionet.biblionet.services.AlumnoService;

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
@RequestMapping("/api/alumnolib")

public class AlumnoController {

    // Inyectamos el servicio UsuarioService
    @Autowired
    private AlumnoService alumnoService;

    // EndPoint para obtener todos los usuarios
    @GetMapping
    public List<Alumno> getAllUsers() {
        return alumnoService.getAllStudents();
    }

    // Endpoint para obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getStudentsById(@PathVariable Long id) {
        // Llamamos al servicio para obtener el usuario
        Optional<Alumno> alumno = alumnoService.getStudentById(id);
        // Si el usuario existe, devolvemos una respuesta OK con el usuario
        // Si no, devolvemos una respuesta Not Found
        return alumno.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para crear un nuevo usuario
    @PostMapping
    public ResponseEntity<Alumno> createStudent(@RequestBody Alumno alumno) {
        // Llamamos al servicio para guardar el nuevo usuario
        Alumno newAlumno = alumnoService.saveStudent(alumno);
        // Devolvemos una respuesta Created con el nuevo usuario
        return new ResponseEntity<>(newAlumno, HttpStatus.CREATED);
    }

    // Endpoint para eliminar un usuario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudents(@PathVariable Long id) {
        // Llamamos al servicio para eliminar el usuario
        alumnoService.deleteStudent(id);
        // Devolvemos una respuesta No Content
        return ResponseEntity.noContent().build();
    }

    // Endpoint para actualizar un alumno por su ID
@PutMapping("/{id}")
public ResponseEntity<Alumno> updateStudent(@PathVariable Long id, @RequestBody Alumno alumnoDetails) {
    // Llamamos al servicio para obtener el alumno existente
    Optional<Alumno> alumnoOptional = alumnoService.getStudentById(id);

    // Si el alumno existe, actualizamos sus datos
    if (alumnoOptional.isPresent()) {
        Alumno alumnoExistente = alumnoOptional.get();

        // Actualizamos los campos necesarios
        alumnoExistente.setMatricula(alumnoDetails.getMatricula());
        alumnoExistente.setNombre(alumnoDetails.getNombre());
        alumnoExistente.setApelido(alumnoDetails.getApelido());
        alumnoExistente.setCarrera(alumnoDetails.getCarrera());
        alumnoExistente.setSemestre(alumnoDetails.getSemestre());
        
        // Agrega aquí más campos si tu entidad tiene otros

        // Guardamos los cambios usando el servicio
        Alumno alumnoActualizado = alumnoService.saveStudent(alumnoExistente);

        // Devolvemos la respuesta con el alumno actualizado
        return ResponseEntity.ok(alumnoActualizado);
    } else {
        // Si no existe, devolvemos un 404
        return ResponseEntity.notFound().build();
    }
}

    
}
