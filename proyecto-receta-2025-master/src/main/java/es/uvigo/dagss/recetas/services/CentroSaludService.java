package es.uvigo.dagss.recetas.services;

import java.util.List;
import es.uvigo.dagss.recetas.entidades.CentroSalud;

public interface CentroSaludService{
	public void crearCentroSalud(CentroSalud centroSalud);
	public void actualizarCentroSalud(CentroSalud centroSalud);
	public void eliminarCentroSalud(CentroSalud centroSalud);
	public List<CentroSalud> buscarTodos();
	public CentroSalud buscarPorId(Long id);
	public List<CentroSalud> buscarActivos();
	public List<CentroSalud> buscarPorProvincia(String provincia);
	public List<CentroSalud> buscarPorLocalidad(String localidad);
	public List<CentroSalud> buscarPorNombre(String nombre);
	public List<CentroSalud> buscarActivos();
}