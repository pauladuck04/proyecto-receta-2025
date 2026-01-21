package es.uvigo.dagss.recetas.services;

import java.util.List;
import es.uvigo.dagss.recetas.entidades.Medico;

public interface MedicoService{
	void crearMedico(Medico medico);
	void actualizarMedico(Medico medico);
	void eliminarMedico(Medico medico);
	Medico buscarPorId(Long id);
	List<Medico> buscarActivos();
	List<Medico> buscarPorNombre(String nombre);
	List<Medico> buscarPorLocalidad(String localidad);
    List<Medico> buscarPorCentroSalud(Long centroId);
}