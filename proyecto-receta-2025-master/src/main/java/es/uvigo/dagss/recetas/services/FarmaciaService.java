package es.uvigo.dagss.recetas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uvigo.dagss.recetas.daos.FarmaciaDAO;
import es.uvigo.dagss.recetas.entidades.Farmacia;

@Service
public class FarmaciaService{
	@Autowired
	private FarmaciaDAO farmaciaDAO;

	public FarmaciaService(){ }

	public void crearFarmacia(Farmacia farmacia){
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

	public List<Farmacia> listarFiltrado(String texto){
		if(texto != null && !texto.isEmpty()){
			return farmaciaDAO.findByNombreContainingIgnoreCaseOrDireccionLocalidadContainingIgnoreCase(texto, texto);
		}
		
		return farmaciaDAO.findAll();
	}
}