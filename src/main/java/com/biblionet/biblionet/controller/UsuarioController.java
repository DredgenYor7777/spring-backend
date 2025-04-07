package com.biblionet.biblionet.controller;

// Importamos la clase Usuario que representa la entidad
import com.biblionet.biblionet.model.Usuario;

// Importamos el servicio UsuarioService que contiene la lógica de negocio
import com.biblionet.biblionet.services.UsuarioService;

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
@RequestMapping("/api/userslib")

public class UsuarioController {

    // Inyectamos el servicio UsuarioService
    @Autowired
    private UsuarioService usuarioService;

    // EndPoint para obtener todos los usuarios
    @GetMapping
    public List<Usuario> getAllUsers() {
        return usuarioService.getAllUsuarios();
    }

    // Endpoint para obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable Long id) {
        // Llamamos al servicio para obtener el usuario
        Optional<Usuario> usuario = usuarioService.getUsuarioById(id);
        // Si el usuario existe, devolvemos una respuesta OK con el usuario
        // Si no, devolvemos una respuesta Not Found
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para crear un nuevo usuario
    @PostMapping
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario) {
        // Llamamos al servicio para guardar el nuevo usuario
        Usuario newUsuario = usuarioService.saveUsuario(usuario);
        // Devolvemos una respuesta Created con el nuevo usuario
        return new ResponseEntity<>(newUsuario, HttpStatus.CREATED);
    }

    // Endpoint para eliminar un usuario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        // Llamamos al servicio para eliminar el usuario
        usuarioService.deleteUsuario(id);
        // Devolvemos una respuesta No Content
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
    // Buscar el usuario por su id
    Optional<Usuario> existingUsuario = usuarioService.getUsuarioById(id);

    // Si el usuario existe, lo actualizamos
    if (existingUsuario.isPresent()) {
        // Verificamos si el correo o nombre ya existen en la base de datos
        if (usuarioService.existsByCorreo(usuario.getCorreo()) && !usuario.getCorreo().equals(existingUsuario.get().getCorreo())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Correo ya existe
        }

        if (usuarioService.existsByNombre(usuario.getNombre()) && !usuario.getNombre().equals(existingUsuario.get().getNombre())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Nombre ya existe
        }

        Usuario updatedUsuario = existingUsuario.get();

        // Actualizamos los campos del usuario
        updatedUsuario.setNombre(usuario.getNombre());
        updatedUsuario.setCorreo(usuario.getCorreo());

        // Guardamos los cambios
        usuarioService.saveUsuario(updatedUsuario);

        // Devolvemos el usuario actualizado
        return ResponseEntity.ok(updatedUsuario);
    } else {
        // Si no encontramos el usuario con ese id, devolvemos un error 404
        return ResponseEntity.notFound().build();
    }
}


}
