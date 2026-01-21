package es.uvigo.dagss.recetas.services;

import es.uvigo.dagss.recetas.entidades.Administrador;
import java.util.List;

public interface AdministradorService{
	void crearAdministrador(Administrador administrador);
	void actualizarAdministrador(Administrador administrador);
	void eliminarAdministrador(Administrador administrador);
	Administrador buscarPorId(Long id);
	List<Administrador> buscarActivos();
}