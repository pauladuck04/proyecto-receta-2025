package es.uvigo.dagss.recetas.daos;

import java.time.LocalDate;
import java.util.List;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uvigo.dagss.recetas.entidades.Cita;
import es.uvigo.dagss.recetas.entidades.Medico;
import es.uvigo.dagss.recetas.entidades.Paciente;
import es.uvigo.dagss.recetas.entidades.Cita;

@Repository
public interface CitaDAO extends JpaRepository<Cita, Long> {
	List<Cita> findByFechaOrderByHoraInicioAsc(LocalDate fecha);
	List<Cita> findByFechaAndMedicoIdOrderByHoraInicioAsc(Long medicoId, LocalDate fecha);
	List<Cita> findByFechaAndPacienteIdOrderByHoraInicioAsc(Long pacienteId, LocalDate fecha);
	List<Cita> findByPacienteIdAndEstadoOrderByFechaAscHoraInicioAsc(Long pacienteId, EstadoCita estado);
	List<Cita> findByMedicoIdAndFechaAndEstado(Long medicoId, LocalDate fecha, EstadoCita estado);
	Optional<Cita> findByMedicoIdAndFechaAndHoraInicio(Long medicoId, LocalDate fecha, LocalTime horaInicio);
}