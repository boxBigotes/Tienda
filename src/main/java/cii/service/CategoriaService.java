package cii.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cii.entities.Categoria;
import cii.repositiry.CategoriaRepository;
/// logica del negocio
/// repositorio--controlador
@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    //Categoria_All
    public List<Categoria> Categoria_all() {
        return categoriaRepository.findAll();  
    }

    //Categoria_byId
    public Optional<Categoria> Categoria_byId(Long id) {
        return categoriaRepository.findById(id);
    }

    //Categoria_save
    public Categoria Categoria_save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    
    //Categoria_update@
    public Categoria Categoria_update(Long id, Categoria categoria) {
        if (categoriaRepository.existsById(id)) {  
            categoria.setCategoriaId(id);  
            return categoriaRepository.save(categoria);
        }
        return null;
    }

    //Categoria_delete
    public boolean Categoria_delete(Long id) {
        if (categoriaRepository.existsById(id)) {  
            categoriaRepository.deleteById(id);  
            return true;
        }
        return false;
    }

    //* Categoria_byNombre
    @SuppressWarnings("rawtypes")
    public Optional Categoria_byNombre(String nombre){
        return categoriaRepository.Categoria_byNombre(nombre);     
    }

}

