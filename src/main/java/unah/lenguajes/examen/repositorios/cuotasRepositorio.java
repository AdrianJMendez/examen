package unah.lenguajes.examen.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.examen.modelos.cuotas;

@Repository
public interface cuotasRepositorio extends JpaRepository<cuotas, Integer> {

}
