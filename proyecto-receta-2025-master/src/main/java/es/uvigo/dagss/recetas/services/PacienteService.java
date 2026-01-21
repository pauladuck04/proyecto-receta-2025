package es.uvigo.dagss.recetas.services;

import java.util.List;

import es.uvigo.dagss.recetas.entidades.Cita;
import es.uvigo.dagss.recetas.entidades.Paciente;

public interface PacienteService{
	void crearPaciente(Paciente paciente);
	void actualizarPaciente(Paciente paciente);
	void eliminarPaciente(Paciente paciente);
	Paciente buscarPorId(Long id);
	List<Paciente> buscarActivos();
	List<Paciente> buscarPorNombre(String nombre);
	List<Paciente> buscarPorMedico(Long medicoId, Long centroSaludId);
	List<Paciente> buscarPorLocalidad(String localidad);
    List<Cita> buscarCitasPlanificadas(Long pacienteId);
}