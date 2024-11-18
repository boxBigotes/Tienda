package cii.repositiry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cii.entities.Categoria;
///interaccion con la bd
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long>{
    
    //Categoria_byNombre
    Optional<Categoria> Categoria_byNombre(String nombre);

}
   
