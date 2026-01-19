package es.uvigo.dagss.recetas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uvigo.dagss.recetas.daos.FarmaciaDAO;
import es.uvigo.dagss.recetas.entidades.Farmacia;

@Service
public class FarmaciaServiceImpl implements FarmaciaService{
	@Autowired
	private FarmaciaDAO farmaciaDAO;

	public FarmaciaServiceImpl(){ }

	public void crearFarmacia(Farmacia farmacia){
		String numColegiado = farmacia.getNumeroColegiado();
		farmacia.setPassword(numColegiado);	
		farmaciaDAO.save(farmacia);
	}

	public void eliminarFarmacia(Farmacia farmacia){
		farmacia.setActivo(false);
        farmaciaDAO.save(farmacia);
	}

	public void actualizarFarmacia(Farmacia farmacia){
		farmaciaDAO.save(farmacia);
	}

	public List<Farmacia> buscarTodos() {
        return farmaciaDAO.findAll();
    }

    public Farmacia buscarPorId(Long id) {
        return farmaciaDAO.findById(id).orElse(null);
    }
	
	public List<Farmacia> buscarActivos() {
		return farmaciaDAO.findByActivoTrue();
	}

	public List<Farmacia> buscarPorNombre(String nombre){
		if(nombre != null && !nombre.isEmpty()){
			return farmaciaDAO.findByNombreContainingIgnoreCase(nombre);
		}else{
			return farmaciaDAO.findAll();
		}
	}
	public List<Farmacia> buscarPorLocalidad(String localidad){
		if(localidad != null && !localidad.isEmpty()){
			return farmaciaDAO.findByDireccionLocalidadContainingIgnoreCase(localidad);
		}else{
			return farmaciaDAO.findAll();
		}
	}
}