package cii.repositiry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cii.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    //producto_byNombre
    Optional<Producto> producto_byNombre(String nombre);

    //producto_allBysubcategoria
    List<Producto> producto_allBysubcategoria(Long subcategoriaId);

    //producto_Bysubcategoria

}
