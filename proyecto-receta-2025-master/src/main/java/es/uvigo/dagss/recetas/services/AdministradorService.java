package es.uvigo.dagss.recetas.services;

import es.uvigo.dagss.recetas.entidades.Administrador;
import java.util.List;

public interface AdministradorService{
	public void crearAdministrador(Administrador administrador);
	public void actualizarAdministrador(Administrador administrador);
	public void eliminarAdministrador(Administrador administrador);
	public List<Administrador> buscarTodos();
	public Administrador buscarPorId(Long id);
	public List<Administrador> buscarActivos();
}