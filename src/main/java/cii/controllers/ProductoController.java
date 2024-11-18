package cii.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cii.entities.Producto;
import cii.service.ProductoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    //producto_All
    @GetMapping
    public List<Producto> producto_All() {
        return productoService.producto_All();
    }

    //producto_byId
    @GetMapping("/{id}")
    public ResponseEntity<Producto> producto_findById(@PathVariable Long id) {
        Optional<Producto> producto = productoService.producto_findById(id);
        return producto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //producto_save
    @PostMapping
    public Producto producto_save(@RequestBody Producto producto) {
        return productoService.producto_save(producto);
    }

    //producto_delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> producto_delete(@PathVariable Long id) {
        productoService.producto_delete(id);
        return ResponseEntity.noContent().build();
    }

    //producto_findBySubcategoria
    @GetMapping("/subcategoria/{nombre}")
    public List<Producto> producto_findBySubcategoria(@PathVariable String nombre) {
        return productoService.producto_findBySubcategoria(nombre);
    }
}
