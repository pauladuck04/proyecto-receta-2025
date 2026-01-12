package es.uvigo.dagss.recetas.daos;

@Repository
public interface MedicoDAO extends JpaRepository<Medico, Long>{
	List<Medico> findByNombreContainingIgnoreCaseOrDireccionLocalidadContainingIgnoreCase(string nombre, String localidad);
	List<Medico> findByCentroSaludId(Long centroSaludId);
	Optional<Medico> findByLogin(String login);
	Optional<Medico> findById(Long id);
}