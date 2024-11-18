package cii.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cii.entities.Empleado;
import cii.repositiry.EmpleadoRepository;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    // Cliente_All
    public List<Empleado> Empleado_findAll() {
        return empleadoRepository.findAll();
    }

    // Cliente_byId
    public Optional<Empleado> Empleado_findById(Long id) {
        return empleadoRepository.findById(id);
    }

    // Cliente_save
    public Empleado Empleado_save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    // Cliente_update
    public Empleado Empleado_update(Long id, Empleado empleado) {
        if (empleadoRepository.existsById(id)) {
            empleado.setClienteId(id);
            return empleadoRepository.save(empleado);
        }
        return null;
    }

    // Cliente_delete
    public boolean Empleado_delete(Long id) {
        if (empleadoRepository.existsById(id)) {
            empleadoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Cliente_byNombre
    public Optional<Empleado> Empleado_byNombre(String nombre) {
        return empleadoRepository.Empleado_byNombre(nombre);
    }
}
