package com.biblionet.biblionet.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

// Indicamos que esta clase es una entidad JPA que se mapeará a una tabla en la base de datos
@Entity
public class Prestamo {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        private LocalDate fechaPrestamo;
        private LocalDate fechaDevolucion;
    
        @ManyToOne
        @JoinColumn(name = "matricula") // Relación con Alumno
        private Alumno alumno;
    
        @ManyToOne
        @JoinColumn(name = "ISBN") // Relación con Libro
        private Inventario Inventario;
    
        // Getters y setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public LocalDate getFechaPrestamo() {
            return fechaPrestamo;
        }

        public void setFechaPrestamo(LocalDate fechaPrestamo) {
            this.fechaPrestamo = fechaPrestamo;
        }

        public LocalDate getFechaDevolucion() {
            return fechaDevolucion;
        }

        public void setFechaDevolucion(LocalDate fechaDevolucion) {
            this.fechaDevolucion = fechaDevolucion;
        }

        public Alumno getAlumno() {
            return alumno;
        }

        public void setAlumno(Alumno alumno) {
            this.alumno = alumno;
        }

        public Inventario getInventario() {
            return Inventario;
        }

        public void setInventario(Inventario Inventario) {
            this.Inventario = Inventario;
        }
     
    
}




