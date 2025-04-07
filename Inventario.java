package com.biblionet.biblionet.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Inventario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String numeroAdquisicion;
        private String ISBN;
        private String titulo;
        private String autor;
        private String editorial;
        private LocalDate año;
        private String areaAcademica;
        private String estado;
        private String clasificacion;
        private String subclasificacion;
        private String ejemplares;

        // Getters y setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNumeroAdquisicion() {
            return numeroAdquisicion;
        }

        public void setNumeroAdquisicion(String numeroAdquisicion) {
            this.numeroAdquisicion = numeroAdquisicion;
        }

        public String getISBN() {
            return ISBN;
        }

        public void setISBN(String ISBN) {
            this.ISBN = ISBN;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public String getEditorial() {
            return editorial;
        }

        public void setEditorial(String editorial) {
            this.editorial = editorial;
        }

        public LocalDate getAño() {
            return año;
        }

        public void setAño(LocalDate año) {
            this.año = año;
        }

        public String getAreaAcademica() {
            return areaAcademica;
        }

        public void setAreaAcademica(String areaAcademica) {
            this.areaAcademica = areaAcademica;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public String getClasificacion() {
            return clasificacion;
        }

        public void setClasificacion(String clasificacion) {
            this.clasificacion = clasificacion;
        }

        public String getSubclasificacion() {
            return subclasificacion;
        }

        public void setSubclasificacion(String subclasificacion) {
            this.subclasificacion = subclasificacion;
        }

        public String getEjemplares() {
            return ejemplares;
        }

        public void setEjemplares(String ejemplares) {
            this.ejemplares = ejemplares;
        }

}
