package com.biblionet.biblionet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Devolucion {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "matricula") // Relación con Alumno
        private Alumno alumno;
    
        @ManyToOne
        @JoinColumn(name = "isbn") // Relación con Libro
        private Inventario inventario;

        // Getters y setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Alumno getAlumno() {
            return alumno;
        }

        public void setAlumno(Alumno alumno) {
            this.alumno = alumno;
        }

        public Inventario getInventario() {
            return inventario;
        }

        public void setInventario(Inventario Inventario) {
            this.inventario = Inventario;
        }
    
}
