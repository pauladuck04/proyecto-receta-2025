package es.uvigo.dagss.recetas.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uvigo.dagss.recetas.daos.CitaDAO;
import es.uvigo.dagss.recetas.daos.MedicoDAO;
import es.uvigo.dagss.recetas.entidades.Cita;
import es.uvigo.dagss.recetas.entidades.CentroSalud;
import es.uvigo.dagss.recetas.entidades.Medico;

@Service
public class MedicoService{
	@Autowired
	private MedicoDAO medicoDAO;

	@Autowired
	private CitaDAO citaDAO;

	public MedicoService(){ }

	public List<Medico> buscarTodos(){
		return medicoDAO.findAll();
	}

	public Medico buscarPorId(Long id){
		return medicoDAO.findById(id).orElse(null);
	}

	public void eliminarMedico(Medico medico) {
        medico.setActivo(false);
        medicoDAO.save(medico);
    }

    public void actualizarMedico(Medico medico) {
        medicoDAO.save(medico);
    }

	public void crearMedico(Medico medico) {
        String numColegiado = medico.getNumeroColegiado();
		medico.setPassword(numColegiado);
		medicoDAO.save(medico);
    }

	public List<Medico> buscarActivos() {
        return medicoDAO.findByActivoTrue();
    }

	public List<Medico> buscarPorNombre(String nombre){
		if(nombre != null && !nombre.isEmpty()){
			return medicoDAO.findByNombreContainingIgnoreCase(nombre);
		}else{
			return medicoDAO.findAll();
		}
	}

	public List<Medico> buscarPorLocalidad(String localidad){
		if(localidad != null && !localidad.isEmpty()){
			return medicoDAO.findByDireccionLocalidadContainingIgnoreCase(localidad);
		}else{
			return medicoDAO.findAll();
		}
	}

	public List<Medico> buscarPorCentroSalud(Long centroId){
		if(centroId != null || centroId != 0){
			return medicoDAO.findByCentroSaludId(centroId);
		}else{
			return medicoDAO.findAll();
		}
	}
}