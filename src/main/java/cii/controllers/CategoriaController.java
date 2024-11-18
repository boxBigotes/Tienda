package cii.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cii.entities.Categoria;
import cii.service.CategoriaService;


@ComponentScan
@RestController
//url para categorias
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    //endpoint Categoria_all
    @GetMapping
    public List<Categoria> Categoria_all(){
        return categoriaService.Categoria_all();
    }

    //endpoint Categoria_byId
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> Categoria_byId(@PathVariable Long id){
        Optional<Categoria> categoria= categoriaService.Categoria_byId(id);
        if (categoria.isPresent()) {
            return new ResponseEntity<>(categoria.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //endpoint Categoria_update
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> Categoria_update(@PathVariable Long id){
        Optional<Categoria> categoria= categoriaService.Categoria_byId(id);
        if (categoria.isPresent()) {
            return new ResponseEntity<>(categoria.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //endpoint Categorria_delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Categoria> Categoria_delete(@PathVariable Long id){
        boolean eliminado= categoriaService.Categoria_delete(id);
        if(eliminado){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //endpoint Categoria_byNombre
    @GetMapping("/{nombre}")
    public ResponseEntity<Categoria> Categoria_byNombre(@PathVariable String nombre){
        @SuppressWarnings("unchecked")
        Optional<Categoria> categoria= categoriaService.Categoria_byNombre(nombre);
        if (categoria.isPresent()) {
            return new ResponseEntity<>(categoria.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
}
