package unah.lenguajes.examen.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.examen.modelos.prestamos;
import unah.lenguajes.examen.repositorios.clienteRepositorio;
import unah.lenguajes.examen.repositorios.prestamosRespositorio;

@Service
public class prestamosServicio {

    @Autowired
    private clienteRepositorio clienteRepositorio;
    @Autowired
    private prestamosRespositorio prestamosRepositorio;

    public prestamos crearPrestamo(prestamos nvoPrestamo, String dni) {

        prestamos prestamo = nvoPrestamo;

        prestamo.setCliente(this.clienteRepositorio.findById(dni).get());

        double n = nvoPrestamo.getPlazo() * 12;

        double i = nvoPrestamo.getInteres() / 12;

        prestamo.setCuota((prestamo.getMonto() * i) / (1 - (Math.pow((1 + i), n))));

        return this.prestamosRepositorio.save(prestamo);
    }
}
