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
	List<Cita> findByMedicoId(Long medicoId);
	List<Cita> findByPacienteId(Long pacienteId);
	List<Cita> findByEstado(EstadoCita estado);
}