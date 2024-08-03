package unah.lenguajes.examen.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.examen.modelos.cliente;
import unah.lenguajes.examen.modelos.prestamos;
import unah.lenguajes.examen.repositorios.clienteRepositorio;

@Service
public class clienteServicio {

    @Autowired
    private clienteRepositorio clienteRepositorio;

    @Autowired
    private prestamosServicio prestamosServicio;

    public cliente crearCliente(cliente nvoCliente) {

        cliente cliente = new cliente();
        cliente = nvoCliente;

        if (clienteRepositorio.existsById(cliente.getDni()) == false) {
            this.clienteRepositorio.save(cliente); // Lo guardo dos veces por que en el servicio para crear prestamos
                                                   // busca un cliente por Id ya creado
            List<prestamos> prestamos = cliente.getPrestamos();
            if (prestamos != null) {
                for (prestamos prestamosActual : prestamos) {
                    this.prestamosServicio.crearPrestamo(prestamosActual, cliente.getDni());
                }
            }
            return this.clienteRepositorio.save(nvoCliente);
        }

        return null;

    }

    public List<cliente> obtenerTodos() {
        return this.clienteRepositorio.findAll();
    }
}
