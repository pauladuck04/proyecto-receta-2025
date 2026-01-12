package es.uvigo.dagss.recetas.daos;

@Repository
public interface PacienteDAO extends JpaRepository<Paciente, Long>{
	List<Paciente> findByNombreContainingIgnoreCaseOrApellidosContainingIgnoreCase(String nombre, String apellidos);
	List<Paciente> findByLocalidadContainingIgnoreCase(String localidad);
	List<Paciente> findByCentroSaludId(Long centroSaludId);
	List<Paciente> findByMedicoId(Long medicoId);
	List<Paciente> findByCentroSaludIdAndMedicoId(Long centroSaludId, Long medicoId);
	Optional<Paciente> findByDni(String dni);
	Optional<Paciente> findByNumTarjetaSanitaria(String numTarjetaSanitaria);
	Optional<Paciente> findByLogin(String login);
}