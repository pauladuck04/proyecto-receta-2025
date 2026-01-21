package es.uvigo.dagss.recetas.services;

import java.util.List;
import es.uvigo.dagss.recetas.entidades.CentroSalud;

public interface CentroSaludService{
	void crearCentroSalud(CentroSalud centroSalud);
	void actualizarCentroSalud(CentroSalud centroSalud);
	void eliminarCentroSalud(CentroSalud centroSalud);
	CentroSalud buscarPorId(Long id);
	List<CentroSalud> buscarPorProvincia(String provincia);
	List<CentroSalud> buscarPorLocalidad(String localidad);
	List<CentroSalud> buscarPorNombre(String nombre);
	List<CentroSalud> buscarActivos();
}