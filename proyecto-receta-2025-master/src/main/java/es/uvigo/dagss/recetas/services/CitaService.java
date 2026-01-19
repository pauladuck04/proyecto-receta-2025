package es.uvigo.dagss.recetas.services;

import java.util.List;
import es.uvigo.dagss.recetas.entidades.Cita;
import es.uvigo.dagss.recetas.entidades.Medico;
import java.time.LocalDate;

public interface CitaService{
	public void actualizarCita(Cita cita);
	public void eliminarCita(Cita cita);
	public List<Cita> buscarTodos();
	public List<Cita> buscarActivos();
	public Cita buscarPorId(Long id);
	public void anularCita(Long id);
	public List<Cita> buscarPorFecha(LocalDateTime fechaHora);
	public List<Cita> buscarPorMedico(Long medicoId);
	public List<Cita> buscarPorPaciente(Long pacienteId);
	public void crearCita(Paciente paciente, LocalDateTime fechaHora);
	public List<LocalTime> obtenerHuecosDisponibles(Medico medico, LocalDateTime fechaHora);
	public List<Cita> buscarPorEstado(Estado estado);
}