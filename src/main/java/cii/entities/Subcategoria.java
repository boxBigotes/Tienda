package cii.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name= "subcategoria")
public class Subcategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subcategoriaId;

    private String nombre;
    private String descripcion;
    
    @ManyToOne
    @JoinColumn(name= "categoria_id", nullable= false)
    private Long categoriaId;

    //Contructor
    public Subcategoria(Long subcategoriaId, String nombre, String descripcion, Long categoriaId) {
        this.subcategoriaId = subcategoriaId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoriaId = categoriaId;
    }
    
    // Getters y Setters
    public Long getSubcategoriaId() {
        return subcategoriaId;
    }

    public void setSubcategoriaId(Long subcategoriaId) {
        this.subcategoriaId = subcategoriaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}
