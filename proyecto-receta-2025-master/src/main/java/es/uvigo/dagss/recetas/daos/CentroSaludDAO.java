package es.uvigo.dagss.recetas.daos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import es.uvigo.dagss.recetas.entidades.CentroSalud;

@Repository
public interface CentroSaludDAO extends JpaRepository<CentroSalud, Long> {
	List<CentroSalud> findByNombreContainingIgnoreCase(String nombre);
	List<CentroSalud> findByDireccionLocalidadContainingIgnoreCase(String localidad);
	List<CentroSalud> findByActivoTrue();
	Optional<CentroSalud> findById(Long id);
	List<CentroSalud> findByDireccionProvinciaIgnoreCase(String provincia);
}