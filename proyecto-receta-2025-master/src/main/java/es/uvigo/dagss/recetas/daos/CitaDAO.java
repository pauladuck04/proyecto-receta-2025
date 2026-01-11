package es.uvigo.dagss.recetas.daos;

import java.time.LocalDate;
import java.util.List;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uvigo.dagss.recetas.entidades.Cita;
import es.uvigo.dagss.recetas.entidades.Medico;
import es.uvigo.dagss.recetas.entidades.Paciente;
import es.uvigo.dagss.recetas.entidades.Cita;

public interface CitaDAO extends JpaRepository<Cita, Long> {
	Cita findByFechaHora(Date fechaHora);
	List<Cita> findByMedico(Medico medico);
	void deleteByFechaHora(Date hora);

	List<Cita> findByFechaHoraBetweenOrderByFechaHoraAsc(Date inicio, Date fin);
	List<Cita> findByFechaHoraBetweenAndMedicoOrderByFechaHora(Medico medico, Date inicio, Date fin);
	List<Cita> findByFechaHoraBetweenAndPacienteOrderByFechaHora(Paciente paciente, Date inicio, Date fin);
	
	List<Cita> findByPacienteAndEstadoCita(Paciente paciente, String estado);
	List<Cita> findByMedicoAndFechaHoraAndEstadoCita(Medico medico, String estado, Date inicio, Date fin);
	List<Cita> findByMedicoAndFecha(Medico medico, LocalDate fecha);
}