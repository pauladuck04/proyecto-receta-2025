package es.uvigo.dagss.recetas.daos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import es.uvigo.dagss.recetas.entidades.CentroSalud;

public interface CentroSaludDAO extends JpaRepository<CentroSalud, Long> {
	CentroSalud findByNombre(String nombre);
	CentroSalud findByTelefono(String telefono);
	CentroSalud findByEmail(String email);
	List<CentroSalud> findByActivoTrue();
	List<CentroSalud> findByNombreContaining(String nombre);
	List<CentroSalud> findByDireccion_CiudadContaining(String ciudad);
	List<CentroSalud> findByDireccion_CalleContaining(String codigoPostal);
	List<CentroSalud> findByDireccion_ProvinciaContaining(String codigoPostal);
	void deleteByNombre(String nombre);
}