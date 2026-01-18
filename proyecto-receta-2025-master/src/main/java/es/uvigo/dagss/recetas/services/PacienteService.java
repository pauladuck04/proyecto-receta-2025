package es.uvigo.dagss.recetas.services;

import java.util.List;
import es.uvigo.dagss.recetas.entidades.Paciente;

public interface PacienteService{
	public void crearPaciente(Paciente paciente);
	public void actualizarPaciente(Paciente paciente);
	public void eliminarPaciente(Paciente paciente);
	public List<Paciente> buscarTodos();
	public Paciente buscarPorId(Long id);
	public List<Paciente> buscarActivos();
	public List<Paciente> buscarPorNombre(String nombre);
	public List<Paciente> buscarPorCentroSalud(String centroSaludId);
	public List<Paciente> buscarPorLocalidad(String localidad);
}