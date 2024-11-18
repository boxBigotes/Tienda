package cii.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productoId;

    private String nombre;
    private Double precio;
    private Integer stock;

    @ManyToOne
    @JoinColumn(name= "subcategoria_id", nullable= false)
    private Long subcategoriaId;

    //contrusctir
    public Producto(Long productoId, String nombre, Double precio, Integer stock,
            Long subcategoriaId) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.subcategoriaId = subcategoriaId;
    }

    // Getters y Setters
    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Long getSubcategoriaId() {
        return subcategoriaId;
    }

    public void setSubcategoriaId(Long subcategoriaId) {
        this.subcategoriaId = subcategoriaId;
    }
}
