package es.uvigo.dagss.recetas.daos;

import es.uvigo.dagss.recetas.entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AdministradorDAO extends JpaRepository<Administrador, Long> {
	Optional<Administrador> findByLoginContainingIgnoreCase(String login);
	List<Administrador> findByNombreContainingIgnoreCase(String nombre);
	List<Administrador> findByEmailContainingIgnoreCase(String email);
	Optional<Administrador> findById(Long id);
	List<Administrador> findByActivoTrue();
}