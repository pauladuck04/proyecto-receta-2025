package es.uvigo.dagss.recetas.services;

import java.util.List;
import es.uvigo.dagss.recetas.entidades.Medico;

public interface MedicoService{
	public Medico crearMedico(Medico medico);
	public Medico actualizarMedico(Medico medico);
	public void eliminarMedico(Medico medico);
	public List<Medico> buscarTodos();
	public Medico buscarPorId(Long id);
	public List<Medico> buscarActivos();
	public List<Medico> buscarPorNombre(String nombre);
	public List<Medico> buscarPorLocalidad(String localidad);
}