package com.biblionet.biblionet.services;

import com.biblionet.biblionet.model.Alumno;

// Importamos el repositorio UsuarioRepository que interactúa con la base de datos
import com.biblionet.biblionet.repository.AlumnoRepository;

// Importamos las anotaciones necesarias de Spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Anotamos la clase como un servicio de Spring
@Service
public class AlumnoService {

       // Inyectamos el repositorio UsuarioRepository
       @Autowired
       private AlumnoRepository alumnoRepository;
   
       // Método para obtener todos los usuarios
       public List<Alumno> getAllStudents(){
           // Utiliza el repositorio para encontrar y devolver todos los usuarios
           return alumnoRepository.findAll();
       }
   
       // Método para obtener un usuario por su ID
       public Optional<Alumno> getStudentById(Long id){
           // Utiliza el repositorio para encontrar un usuario por su ID
           return alumnoRepository.findById(id);
       }
   
       // Método para guardar un nuevo usuario o actualizar uno existente
       public Alumno saveStudent(Alumno usuario){
           // Utiliza el repositorio para guardar el usuario
           return alumnoRepository.save(usuario);
       }
   
       // Método para eliminar un usuario por su ID
       public void deleteStudent(Long id){
           // Utiliza el repositorio para eliminar el usuario por su ID
           alumnoRepository.deleteById(id);
       }
    
}
