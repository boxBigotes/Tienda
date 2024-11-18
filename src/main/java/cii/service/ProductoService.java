package cii.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cii.entities.Producto;
import cii.repositiry.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    //producto_All
    public List<Producto> producto_All(){
        return productoRepository.findAll();
    }

    //product_byId
    public Optional<Producto> product_findById(Long id){
        return productoRepository.findById(id);
    }

    //producto_save
    public Producto producto_save(Producto producto){
        return productoRepository.save(producto);
    }

    //producto_update
    public Producto producto_update(Long id,Producto producto){
        if(productoRepository.existsById(id)){
            producto.setProductoId(id);
            return productoRepository.save(producto);
        }
        return null;
    }

    //producto_delete
    public boolean producto_delete(Long id){
        if(productoRepository.existsById(id)){
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //producto_byNombre
    public Optional<Producto> producto_byNombre(String nombre){
        return productoRepository.producto_byNombre(nombre);
    }

    //pproducto_findBySubcategoria
    public List<Producto> producto_findBySubcategoria(String nombre){
        return productoRepository.producto_findBySubcategoria(nombre);
    }

    
}
