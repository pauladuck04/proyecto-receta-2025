package es.uvigo.dagss.recetas.services;

import java.util.List;
import es.uvigo.dagss.recetas.entidades.Prescripcion;

public interface PrescripcionService{
	void crearPrescripcion(Prescripcion prescripcion);
	void actualizarPrescripcion(Prescripcion prescripcion);
	void eliminarPrescripcion(Prescripcion prescripcion);
	Prescripcion buscarPorId(Long id);
	List<Prescripcion> buscarActivos();
	List<Prescripcion> buscarPorMedico(Long medicoId);
	List<Prescripcion> buscarPorPaciente(Long pacienteId);
    void anularPrescripcion(Long prescripcionId);
}