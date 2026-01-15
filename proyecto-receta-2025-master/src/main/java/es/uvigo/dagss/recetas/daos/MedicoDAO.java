package es.uvigo.dagss.recetas.daos;

@Repository
public interface MedicoDAO extends JpaRepository<Medico, Long>{
	List<Medico> findByNombreContainingIgnoreCase(string nombre);
	List<Medico> findByDireccionLocalidadContainingIgnoreCase(String localidad);
	List<Medico> findByCentroSaludId(Long centroSaludId);
	Optional<Medico> findByLoginContainingIgnoreCase(String login);
	Optional<Medico> findById(Long id);
	List<Medico> findByActivoTrue();
}