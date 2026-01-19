package es.uvigo.dagss.recetas.services;

import java.util.List;
import es.uvigo.dagss.recetas.entidades.Prescripcion;

public interface PrescripcionService{
	public void crearPrescripcion(Prescripcion prescripcion, Medico medico);
	public void actualizarPrescripcion(Prescripcion prescripcion);
	public void eliminarPrescripcion(Prescripcion prescripcion);
	public List<Prescripcion> buscarTodos();
	public Prescripcion buscarPorId(Long id);
	public List<Prescripcion> buscarActivos();
	public List<Prescripcion> buscarPorMedico(Long medicoId);
	public List<Prescripcion> buscarPorPaciente(Long pacienteId);
}