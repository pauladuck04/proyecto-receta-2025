package es.uvigo.dagss.recetas.daos;

import java.time.LocalDate;
import java.util.List;
import java.util.Date;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.uvigo.dagss.recetas.entidades.EstadoCita;

import es.uvigo.dagss.recetas.entidades.Cita;
import es.uvigo.dagss.recetas.entidades.Medico;
import es.uvigo.dagss.recetas.entidades.Paciente;
import es.uvigo.dagss.recetas.entidades.Cita;

@Repository
public interface CitaDAO extends JpaRepository<Cita, Long> {
    List<Cita> findByFechaHoraOrderByFechaHoraAsc(LocalDateTime fechaHora);
	List<Cita> findByMedicoAndFechaHoraOrderByFechaHoraAsc(Medico medico, LocalDateTime fechaHora);
	List<Cita> findByMedicoId(Long medicoId);
	List<Cita> findByPacienteId(Long pacienteId);
	List<Cita> findByEstadoCita(EstadoCita estado);
	List<Cita> findByActivoTrue();
}