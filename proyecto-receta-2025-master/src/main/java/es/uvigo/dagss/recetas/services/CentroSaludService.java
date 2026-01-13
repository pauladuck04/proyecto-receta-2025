package es.uvigo.dagss.recetas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uvigo.dagss.recetas.daos.CentroSaludDAO;
import es.uvigo.dagss.recetas.entidades.CentroSalud;

@Service
public class CentroSaludService{
	@Autowired
	private CentroSaludDAO CentroSaludDAO;

	public CentroSaludService(){ }

	public List<CentroSalud> buscarTodos() {
        return centroSaludDAO.findAll();
    }

	public CentroSalud buscarPorId(Long id) {
        return centroSaludDAO.findById(id).orElse(null);
    }

	public List<CentroSalud> buscarActivos() {
        return centroSaludDAO.findByActivoTrue();
    }

	public void eliminarCentroSalud(CentroSalud centroSalud) {
        centroSalud.setActivo(false);
        centroSaludDAO.save(centroSalud);
    }

    public void actualizarCentroSalud(CentroSalud centroSalud) {
        centroSaludDAO.save(centroSalud);
    }

    public void crearCentroSalud(CentroSalud centroSalud) {
        centroSaludDAO.save(centroSalud);
    }

	public List<CentroSalud> listarFiltrado(String filtro){
        if(filtro == null || filtro.isEmpty()){
            return centroSaludDAO.findAll();
        }

        return centroSaludDAO.findByNombreContainingIgnoreCaseOrLocalidadContainingIgnoreCase(filtro, filtro)
    }

    public List<CentroSalud> buscarPorProvincia(String provincia){
        if(provincia != null && !provincia.isEmpty()){
            return centroSaludDAO.findByDireccionProvinciaIgnoreCase(provincia);
        }

        return new ArrayList<>();
    }
}