package cii.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cii.entities.ProductoPedido;

@Repository
public interface ProductoPedidoRepository extends JpaRepository<ProductoPedido, Long> {
    // Métodos adicionales si es necesario
}