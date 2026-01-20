package es.uvigo.dagss.recetas.services;

import java.util.List;
import java.util.Optional;

import es.uvigo.dagss.recetas.entidades.Farmacia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uvigo.dagss.recetas.daos.AdministradorDAO;
import es.uvigo.dagss.recetas.services.AdministradorService;
import es.uvigo.dagss.recetas.entidades.Administrador;

@Service
public class AdministradorServiceImpl implements AdministradorService{
	@Autowired
	public AdministradorDAO administradorDAO;

	public AdministradorServiceImpl(){ }

	public void crearAdministrador(Administrador administrador){
		administradorDAO.save(administrador);
	}

	public void eliminarAdministrador(Administrador administrador){
		administrador.setActivo(false);
		administradorDAO.save(administrador);
	}

	public void actualizarAdministrador(Administrador administrador){
		administradorDAO.save(administrador);
	}

	public List<Administrador> buscarTodos(){
		return administradorDAO.findAll();
	}

	public Administrador buscarPorId(Long id){
		return administradorDAO.findById(id).orElse(null);
	}

	public List<Administrador> buscarActivos() {
        return administradorDAO.findByActivoTrue();
    }
}