package com.biblionet.biblionet.controller;


// Importamos la clase Inventario que representa la entidad
import com.biblionet.biblionet.model.Inventario;
// Importamos el servicio InventarioService que contiene la lógica de negocio
import com.biblionet.biblionet.services.InventarioService;

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
@RequestMapping("/api/inventariolib")

public class InventarioController {

     // Inyectamos el servicio InventarioService
    @Autowired
    private InventarioService inventarioService;

    // EndPoint para obtener todos el inventario
    @GetMapping
    public List<Inventario> getAllUsers() {
        return inventarioService.getAllInventory();
    }

    // Endpoint para obtener un inventario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Inventario> getInvById(@PathVariable Long id) {
        // Llamamos al servicio para obtener el usuario
        Optional<Inventario> inventario = inventarioService.getInventoryById(id);
        // Si el usuario existe, devolvemos una respuesta OK con el inventario
        // Si no, devolvemos una respuesta Not Found
        return inventario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para crear un nuevo inventario
    @PostMapping
    public ResponseEntity<Inventario> createInv(@RequestBody Inventario inventario) {
        // Llamamos al servicio para guardar el nuevo inventario
        Inventario newInventario = inventarioService.saveInventory(inventario); 
        // Devolvemos una respuesta Created con el nuevo inventario
        return new ResponseEntity<>(newInventario, HttpStatus.CREATED);
    }

    // Endpoint para eliminar un usuario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInv(@PathVariable Long id) {
        // Llamamos al servicio para eliminar el inventario
        inventarioService.deleteInventory(id); 
        // Devolvemos una respuesta No Content
        return ResponseEntity.noContent().build();
    }


     // Endpoint para actualizar un libro por su ID
     @PutMapping("/{id}")
     public ResponseEntity<Inventario> updateInventario(@PathVariable Long id, @RequestBody Inventario inventario) {
         // Buscar el inventario con el id proporcionado
         Optional<Inventario> existingInventario = inventarioService.getInventoryById(id);
         
         // Si el inventario existe, lo actualizamos
         if (existingInventario.isPresent()) {
             Inventario updatedInventario = existingInventario.get();
     
             // Actualizamos los campos con los datos del nuevo inventario
             updatedInventario.setNumeroAdquisicion(inventario.getNumeroAdquisicion());
             updatedInventario.setISBN(inventario.getISBN());
             updatedInventario.setTitulo(inventario.getTitulo());
             updatedInventario.setAutor(inventario.getAutor());
             updatedInventario.setEditorial(inventario.getEditorial());
             updatedInventario.setAño(inventario.getAño());
             updatedInventario.setAreaAcademica(inventario.getAreaAcademica());
             updatedInventario.setEstado(inventario.getEstado());
             updatedInventario.setClasificacion(inventario.getClasificacion());
             updatedInventario.setSubclasificacion(inventario.getSubclasificacion());
             updatedInventario.setEjemplares(inventario.getEjemplares());
     
             // Guardamos los cambios
             inventarioService.saveInventory(updatedInventario);
     
             // Devolvemos el inventario actualizado
             return ResponseEntity.ok(updatedInventario);
         } else {
             // Si no encontramos el inventario con ese id, devolvemos un error 404
             return ResponseEntity.notFound().build();
         }
     }
     
    
}
