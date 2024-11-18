package cii.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductoPedido {
    
    @Id
    private Long productopedidoID;

    @ManyToOne
    private Producto producto; 

    private Integer cantidad;

    public ProductoPedido(Long productopedidoID, Producto producto, Integer cantidad) {
        this.productopedidoID = productopedidoID;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Long getProductopedidoID() {
        return productopedidoID;
    }

    public void setProductopedidoID(Long productopedidoID) {
        this.productopedidoID = productopedidoID;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}
