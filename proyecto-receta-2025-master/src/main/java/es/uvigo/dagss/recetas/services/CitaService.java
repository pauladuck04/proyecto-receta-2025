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
	public List<Cita> buscarPorFecha(String fecha);
	public List<Cita> buscarPorMedico(Long medicoId);
	public List<Cita> buscarPorPaciente(Long pacienteId);
	public void crearCita(Paciente paciente, LocalDate fecha, LocalTime hora);
	public List<LocalTime> obtenerHuecosDisponibles(Medico medico, LocalDate fecha);
	public List<Cita> buscarPorEstado(Estado estado);
}