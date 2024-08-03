package unah.lenguajes.examen.contraladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.examen.modelos.cliente;
import unah.lenguajes.examen.servicios.clienteServicio;

@RestController
@RequestMapping("/api/cliente")
public class clienteControlador {

    @Autowired
    private clienteServicio clienteServicio;

    @PostMapping("/crear")
    public cliente crearNuevo(@RequestBody cliente Nvocliente) {
        return clienteServicio.crearCliente(Nvocliente);
    }
}
