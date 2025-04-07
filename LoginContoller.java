package com.biblionet.biblionet.controller;

// Importamos la clase Inventario que representa la entidad
import com.biblionet.biblionet.model.Login;

// Importamos el servicio InventarioService que contiene la lógica de negocio
import com.biblionet.biblionet.services.LoginService;

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
@RequestMapping("/api/loginlib")

public class LoginContoller {

    // Inyectamos el servicio LoginService
    @Autowired
    private LoginService loginService;

    // EndPoint para obtener todos los logins
    @GetMapping
    public List<Login> getAllLogin() {
        return loginService.getAllLogins();
    }

    // Endpoint para obtener un login por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Login> getLoginById(@PathVariable Long id) {
        // Llamamos al servicio para obtener el usuario
        Optional<Login> login = loginService.getLoginById(id);
        // Si el usuario existe, devolvemos una respuesta OK con el inventario
        // Si no, devolvemos una respuesta Not Found
        return login.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para crear un nuevo inventario
    @PostMapping
    public ResponseEntity<Login> createLogin(@RequestBody Login login) {
        // Llamamos al servicio para guardar el nuevo inventario
        Login newLogin = loginService.saveLogin(login);
        // Devolvemos una respuesta Created con el nuevo inventario
        return new ResponseEntity<>(newLogin, HttpStatus.CREATED);
    }

    // Endpoint para eliminar un usuario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLogin(@PathVariable Long id) {
        // Llamamos al servicio para eliminar el inventario
        loginService.deleteLogin(id);
        // Devolvemos una respuesta No Content
        return ResponseEntity.noContent().build();
    }

    // Endpoint para actualizar una entidad por su ID
    @PutMapping("/{id}")
    public ResponseEntity<Login> updateLogin(@PathVariable Long id, @RequestBody Login login) {
        // Buscar la entidad por su id
        Optional<Login> loginU = loginService.getLoginById(id);

        // Si la entidad existe, la actualizamos
        if (loginU.isPresent()) {
            Login updatedLogin = loginU.get();

            // Actualizamos los campos de la entidad
            updatedLogin.setContrasena(login.getContrasena()); // Actualiza la contrasena
            updatedLogin.setUsuario(login.getUsuario()); // Actualiza la relación con Usuario

            // Guardamos los cambios
            loginService.saveLogin(updatedLogin);

            // Devolvemos la entidad actualizada
            return ResponseEntity.ok(updatedLogin);
        } else {
            // Si no encontramos la entidad con ese id, devolvemos un error 404
            return ResponseEntity.notFound().build();
        }
    }

}
