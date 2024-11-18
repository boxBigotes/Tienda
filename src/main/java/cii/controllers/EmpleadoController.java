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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cii.entities.Empleado;
import cii.service.EmpleadoService;

@ComponentScan
@RestController
@RequestMapping("/api/clientes") 
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    // Endpoint Cliente_all
    @GetMapping
    public List<Empleado> Cliente_all() {
        return empleadoService.Empleado_findAll();
    }

    // Endpoint Cliente_byId
    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Long id) {
        Optional<Empleado> empleado = empleadoService.Empleado_findById(id);
        if(empleado.isPresent()){
            return new ResponseEntity<>(empleado.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(empleado.get(), HttpStatus.NOT_FOUND);
        }
    }

    //Endpoint Cliente_save
    @PostMapping
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado) {
        Empleado Empleado_save = empleadoService.Empleado_save(empleado);
        return new ResponseEntity<>(Empleado_save, HttpStatus.CREATED);
    }

    // Endpoint Cliente_update
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> Empleado_update(@PathVariable Long id) {
        Optional<Empleado> empleado = empleadoService.Empleado_findById(id);
        if(empleado.isPresent()){
            return new ResponseEntity<>(empleado.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(empleado.get(), HttpStatus.NOT_FOUND);
        }
    }

    //Endpoint Cliente_delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Empleado_delete(@PathVariable Long id) {
        boolean eliminado = empleadoService.Empleado_delete(id);
        if(eliminado){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

    //Endpoint Cliente_byNombre
    @GetMapping("/buscar")
    public ResponseEntity<Empleado> Empleado_byNombre(@RequestParam String nombre) {
        Optional<Empleado> empleado = empleadoService.Empleado_byNombre(nombre);
        if(empleado.isPresent()){
            return new ResponseEntity<>(empleado.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(empleado.get(), HttpStatus.NOT_FOUND);
        }
    }
}