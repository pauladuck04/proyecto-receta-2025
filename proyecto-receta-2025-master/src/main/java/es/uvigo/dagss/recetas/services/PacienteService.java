package es.uvigo.dagss.recetas.services;

import java.util.List;

import es.uvigo.dagss.recetas.entidades.Cita;
import es.uvigo.dagss.recetas.entidades.Paciente;

public interface PacienteService{
	public void crearPaciente(Paciente paciente);
	public void actualizarPaciente(Paciente paciente);
	public void eliminarPaciente(Paciente paciente);
	public Paciente buscarPorId(Long id);
	public List<Paciente> buscarActivos();
	public List<Paciente> buscarPorNombre(String nombre);
	public List<Paciente> buscarPorMedico(Long medicoId, Long centroSaludId);
	public List<Paciente> buscarPorLocalidad(String localidad);
    public List<Cita> buscarCitasPlanificadas(Long pacienteId);
}