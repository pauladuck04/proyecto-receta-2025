package es.uvigo.dagss.recetas.daos;

@Repository
public interface PacienteDAO extends JpaRepository<Paciente, Long>{
	List<Paciente> findByNombreContainingIgnoreCaseOrDireccionLocalidadContainingIgnoreCase(String nombre, String localidad);
	List<Paciente> findByCentroSaludId(Long centroSaludId);
	List<Paciente> findByMedicoId(Long medicoId);
	Optional<Paciente> findByDni(String dni);
	Optional<Paciente> findByNumTarjetaSanitaria(String numTarjetaSanitaria);
	Optional<Paciente> findByLogin(String login);
	List<Paciente> findByActivoTrue();

}