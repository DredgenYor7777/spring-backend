package com.biblionet.biblionet.services;

// Importamos la clase Login que representa la entidad
import com.biblionet.biblionet.model.Login;

// Importamos el repositorio UsuarioRepository que interactúa con la base de datos
import com.biblionet.biblionet.repository.LoginRepository;

// Importamos las anotaciones necesarias de Spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Anotamos la clase como un servicio de Spring
@Service
public class LoginService {

        @Autowired
    private LoginRepository loginRepository; 

    // Método para obtener todos los logins
    public List<Login> getAllLogins() {
        // Utiliza el repositorio para encontrar y devolver todos los logins
        return loginRepository.findAll();
    }

    // Método para obtener un usuario por su ID
    public Optional<Login> getLoginById(Long id) {
        // Utiliza el repositorio para encontrar un login por su ID
        return loginRepository.findById(id);
    }

    // Método para guardar un nuevo login o actualizar uno existente
    public Login saveLogin(Login login) {
        // Utiliza el repositorio para guardar el login
        return loginRepository.save(login);
    }

    // Método para eliminar un login por su ID
    public void deleteLogin(Long id) {
        // Utiliza el repositorio para eliminar el login por su ID
        loginRepository.deleteById(id);
    }
    
}
