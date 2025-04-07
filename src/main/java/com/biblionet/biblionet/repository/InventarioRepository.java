package com.biblionet.biblionet.repository;


// Importamos la clase Usuario que representa la entidad
import com.biblionet.biblionet.model.Inventario;
// Importamos la interfaz JpaRepository que nos proporciona métodos CRUD estándar
import org.springframework.data.jpa.repository.JpaRepository;
// Importamos la anotación Repository que indica que esta interfaz es un repositorio
import org.springframework.stereotype.Repository;

// Indicamos que esta interfaz es un repositorio
@Repository
// Definimos la interfaz UsuarioRepository que extiende JpaRepository
// JpaRepository<T, ID> toma dos parámetros: la entidad y el tipo de la clave primaria

public interface InventarioRepository extends JpaRepository<Inventario, Long>{
    // JpaRepository ya proporciona métodos CRUD básicos como save, findById, findAll, deleteById, etc.
    // Podemos agregar métodos personalizados si es necesario
    
}
