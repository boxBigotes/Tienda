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

import cii.entities.Subcategoria;
import cii.service.SubcategoriaService;

@ComponentScan
@RestController
@RequestMapping("/api/subcategorias")
public class SubcategoriaController {
    @Autowired
    private SubcategoriaService subcategoriaService;

    //endpoint SubCategoria_All
    @GetMapping
    public List<Subcategoria> subcategoria_All(){
        return subcategoriaService.subcategoria_All();
    }

    //endpoint SubCategoria_byId
    @GetMapping("/{id}")
    public ResponseEntity<Subcategoria> subcategoria_byId(@PathVariable Long id){
        Optional<Subcategoria> subcategoria= subcategoriaService.subcategoria_byId(id);
        if (subcategoria.isPresent()) {
            return new ResponseEntity<>(subcategoria.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //endpoint SubCategoria_update
    @GetMapping("/{id}")
    public ResponseEntity<Subcategoria> subcategoria_update(@PathVariable Long id){
        Optional<Subcategoria> subcategoria= subcategoriaService.subcategoria_byId(id);
        if (subcategoria.isPresent()) {
            return new ResponseEntity<>(subcategoria.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //endpoint SubCategorria_delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Subcategoria> Subcategoria_delete(@PathVariable Long id){
        boolean eliminado= subcategoriaService.subcategoria_delete(id);
        if(eliminado){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //endpoint subcategoria_byNombre
    @GetMapping("/{nombre}")
    public ResponseEntity<Subcategoria> subcategoria_byNombre(@PathVariable String nombre){
        @SuppressWarnings("unchecked")
        Optional<Subcategoria> subcategoria= subcategoriaService.subcategoria_byNombre(nombre);
        if (subcategoria.isPresent()) {
            return new ResponseEntity<>(subcategoria.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    //endpoint subcategoria_allBycategoria
    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<Subcategoria>> subcategoria_allBycategoria(@PathVariable long categoriaId){
        List<Subcategoria> subcategoria= subcategoriaService.subcategoria_allBycategoria(categoriaId);
        return new ResponseEntity<>(subcategoria, HttpStatus.OK);
    }   


}
