package com.biblionet.biblionet.services;


import com.biblionet.biblionet.model.Devolucion;
// Importamos el repositorio UsuarioRepository que interactúa con la base de datos
import com.biblionet.biblionet.repository.DevolucionRepository;

// Importamos las anotaciones necesarias de Spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Anotamos la clase como un servicio de Spring
@Service

public class DevolucionService {

     // Inyectamos el repositorio DevolucionRepository
       @Autowired
       private DevolucionRepository devolucionRepository;
   
       // Método para obtener todos las devoluciones
       public List<Devolucion> getAllDevolucions(){
           // Utiliza el repositorio para encontrar y devolver todos las devoluciones
           return devolucionRepository.findAll();
       }
   
       // Método para obtener una devolución por su ID
       public Optional<Devolucion> getDevolucionsById(Long id){
           // Utiliza el repositorio para encontrar una devolución por su ID
           return devolucionRepository.findById(id);
       }
   
       // Método para guardar un nuevo usuario o actualizar uno existente
       public Devolucion saveDevolucions(Devolucion devolucion){
           // Utiliza el repositorio para guardar la devolución
           return devolucionRepository.save(devolucion);
       }
   
       // Método para eliminar una devolución por su ID
       public void deleteDevolucions(Long id){
           // Utiliza el repositorio para eliminar el usuario por su ID
           devolucionRepository.deleteById(id);
       }
    
}
