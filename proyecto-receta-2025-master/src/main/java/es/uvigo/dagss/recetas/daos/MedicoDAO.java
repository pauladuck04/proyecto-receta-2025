package es.uvigo.dagss.recetas.daos;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.uvigo.dagss.recetas.entidades.Medico;

@Repository
public interface MedicoDAO extends JpaRepository<Medico, Long>{
	List<Medico> findByNombreContainingIgnoreCase(String nombre);
	List<Medico> findByDireccionLocalidadContainingIgnoreCase(String localidad);
	List<Medico> findByCentroSaludId(Long centroSaludId);
    Optional<Medico> findById(Long id);
	List<Medico> findByActivoTrue();
}