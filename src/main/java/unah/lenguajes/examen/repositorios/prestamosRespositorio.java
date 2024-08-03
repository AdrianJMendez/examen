package unah.lenguajes.examen.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.examen.modelos.prestamos;

@Repository
public interface prestamosRespositorio extends JpaRepository<prestamos, Integer> {

}
