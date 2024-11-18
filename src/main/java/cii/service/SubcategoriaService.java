package cii.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cii.entities.Subcategoria;
import cii.repositiry.SubcategoriaRepository;

@Service
public class SubcategoriaService {
    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    //subcategoria_All
    public List<Subcategoria> subcategoria_All() {
        return subcategoriaRepository.findAll();  
    }

    //subcategoria_byId
    public Optional<Subcategoria> subcategoria_byId(Long id) {
        return subcategoriaRepository.findById(id);
    }

    //subcategoria_save
    public Subcategoria subcategoria_save(Subcategoria subcategoria) {
        return subcategoriaRepository.save(subcategoria);
    }
    
    //subcategoria_update@
    public Subcategoria subcategoria_update(Long id, Subcategoria subcategoria) {
        if (subcategoriaRepository.existsById(id)) {  
            subcategoria.setCategoriaId(id);  
            return subcategoriaRepository.save(subcategoria);
        }
        return null;
    }

    //subcategoria_delete
    public boolean subcategoria_delete(Long id) {
        if (subcategoriaRepository.existsById(id)) {  
            subcategoriaRepository.deleteById(id);  
            return true;
        }
        return false;
    }

    //subcategoria_byNombre
    @SuppressWarnings("rawtypes")
    public Optional subcategoria_byNombre(String nombre){
        return subcategoriaRepository.subcategoria_byNombre(nombre);     
    }

    //subcategoria_allBycategoria
    public List<Subcategoria> subcategoria_allBycategoria(Long categoriaId){
        return subcategoriaRepository.subcategoria_allBycategoria(categoriaId);
    }

}
