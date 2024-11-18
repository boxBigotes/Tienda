package cii.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cii.entities.ProductoPedido;
import cii.repositiry.ProductoPedidoRepository;

@Service
public class ProductoPedidoService {

    @Autowired
    private ProductoPedidoRepository productoPedidoRepository;

    //ProductoPedido_findAll
    public List<ProductoPedido> ProductoPedido_findAll() {
        return productoPedidoRepository.findAll();
    }

    //ProductoPedido_byById
    public Optional<ProductoPedido> ProductoPedido_byById(Long id) {
        return productoPedidoRepository.findById(id);
    }

    //ProductoPedido_save
    public ProductoPedido ProductoPedido_save(ProductoPedido productoPedido) {
        return productoPedidoRepository.save(productoPedido);
    }

    //ProductoPedido_deleteById
    public void ProductoPedido_deleteById(Long id) {
        productoPedidoRepository.deleteById(id);
    }
}
