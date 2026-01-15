package es.uvigo.dagss.recetas.services;

import java.util.List;
import es.uvigo.dagss.recetas.entidades.Cita;

public interface CitaService{
	public Cita crearCita(Cita cita);
	public Cita actualizarCita(Cita cita);
	public void eliminarCita(Cita cita);
	public List<Cita> buscarTodos();
	public List<Cita> buscarActivos();
	public Cita buscarPorId(Long id);
	public void anularCita(Long id);
	public List<Cita> buscarPorFecha(String fecha);
	public List<Cita> buscarPorMedico(Long medicoId);
	public List<Cita> buscarPorPaciente(Long pacienteId);
}