package com.biblionet.biblionet.services;

// Importamos la clase Usuario que representa la entidad
import com.biblionet.biblionet.model.Usuario;

// Importamos el repositorio UsuarioRepository que interactúa con la base de datos
import com.biblionet.biblionet.repository.UsuarioRepository;

// Importamos las anotaciones necesarias de Spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Anotamos la clase como un servicio de Spring
@Service
public class UsuarioService {

        // Inyectamos el repositorio UsuarioRepository
        @Autowired
        private UsuarioRepository usuarioRepository;
    
        // Método para obtener todos los usuarios
        public List<Usuario> getAllUsuarios(){
            // Utiliza el repositorio para encontrar y devolver todos los usuarios
            return usuarioRepository.findAll();
        }
    
        // Método para obtener un usuario por su ID
        public Optional<Usuario> getUsuarioById(Long id){
            // Utiliza el repositorio para encontrar un usuario por su ID
            return usuarioRepository.findById(id);
        }
    
        // Método para guardar un nuevo usuario o actualizar uno existente
        public Usuario saveUsuario(Usuario usuario){
            // Utiliza el repositorio para guardar el usuario
            return usuarioRepository.save(usuario);
        }
    
        // Método para eliminar un usuario por su ID
        public void deleteUsuario(Long id){
            // Utiliza el repositorio para eliminar el usuario por su ID
            usuarioRepository.deleteById(id);
        }

        public boolean existsByCorreo(String correo) {
            // Verifica si ya existe un usuario con el correo dado
            return usuarioRepository.existsByCorreo(correo);
        }
        
        public boolean existsByNombre(String nombre) {
            // Verifica si ya existe un usuario con el nombre dado
            return usuarioRepository.existsByNombre(nombre);
        }
        
    
}
