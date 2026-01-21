package es.uvigo.dagss.recetas.daos;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.uvigo.dagss.recetas.entidades.EstadoCita;

import es.uvigo.dagss.recetas.entidades.Cita;
import es.uvigo.dagss.recetas.entidades.Medico;
import es.uvigo.dagss.recetas.entidades.Paciente;

@Repository
public interface CitaDAO extends JpaRepository<Cita, Long> {
    List<Cita> findByFechaHoraOrderByFechaHoraAsc(LocalDateTime fechaHora);
	List<Cita> findByMedicoAndFechaHoraOrderByFechaHoraAsc(Medico medico, LocalDateTime fechaHora);
	List<Cita> findByMedicoId(Long medicoId);
	List<Cita> findByPacienteId(Long pacienteId);
	List<Cita> findByActivoTrue();
    List<Cita> findByPacienteAndEstadoCita(Paciente paciente, EstadoCita estadoCita);
    List <Cita> findByMedicoAndFechaHoraBetweenAndEstadoCita(Medico medico, LocalDateTime inicio, LocalDateTime fin, EstadoCita estadoCita);
}