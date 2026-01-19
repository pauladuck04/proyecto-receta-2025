package es.uvigo.dagss.recetas.daos;

import es.uvigo.dagss.recetas.entidades.Farmacia;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmaciaDAO extends JpaRepository<Farmacia, Long>{
	List<Farmacia> findByNombreContainingIgnoreCase(String nombre);
	List<Farmacia> findByDireccionLocalidadContainingIgnoreCase(String localidad);
	List<Farmacia> findByProvinciaIgnoreCase(String provincia);
	Optional<Farmacia> findByLogin(String login);
	List<Farmacia> findByActivoTrue();
}