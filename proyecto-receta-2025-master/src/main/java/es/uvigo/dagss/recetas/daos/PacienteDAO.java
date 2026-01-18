package es.uvigo.dagss.recetas.daos;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.uvigo.dagss.recetas.entidades.Paciente;

@Repository
public interface PacienteDAO extends JpaRepository<Paciente, Long>{
	List<Paciente> findByNombreContainingIgnoreCase(String nombre);
	List<Paciente> findByDireccionLocalidadContainingIgnoreCase(String localidad);
	List<Paciente> findByCentroSaludId(Long centroSaludId);
	List<Paciente> findByMedicoId(Long medicoId);
	Optional<Paciente> findByDniContainingIgnoreCase(String dni);
	Optional<Paciente> findByNumTarjetaSanitariaContainingIgnoreCase(String numTarjetaSanitaria);
	Optional<Paciente> findByLogin(String login);
	List<Paciente> findByActivoTrue();

}