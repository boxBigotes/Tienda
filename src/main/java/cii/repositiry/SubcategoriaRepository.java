package cii.repositiry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cii.entities.Subcategoria;


@Repository
public interface SubcategoriaRepository extends JpaRepository<Subcategoria, Long>{
   
    //subcategoria_byNombre
    Optional<Subcategoria> subcategoria_byNombre(String nombre);

    //subcategoria_allBycategoria
    List<Subcategoria> subcategoria_allBycategoria(Long categoriaId);

    
}
