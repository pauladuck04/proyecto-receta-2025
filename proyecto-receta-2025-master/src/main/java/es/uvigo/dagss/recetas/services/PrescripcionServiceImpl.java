package es.uvigo.dagss.recetas.services;

import java.util.List;

import es.uvigo.dagss.recetas.daos.FarmaciaDAO;
import es.uvigo.dagss.recetas.entidades.Prescripcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.uvigo.dagss.recetas.daos.PrescripcionDAO;
import es.uvigo.dagss.recetas.daos.RecetaDAO;


@Service
public class PrescripcionServiceImpl implements PrescripcionService {
	@Autowired
    private PrescripcionDAO prescripcionDAO;

	@Autowired
    private RecetaDAO recetaDAO;

    @Autowired
    private FarmaciaDAO farmaciaDAO;

	@Autowired
    private RecetaService recetaService;

	public PrescripcionServiceImpl(){ }

    public void crearPrescripcion(Prescripcion prescripcion) {
        Prescripcion nuevaPrescripcion = prescripcionDAO.save(prescripcion);
        recetaService.generarPlanRecetas(nuevaPrescripcion);
    }

	public void actualizarPrescripcion(Prescripcion prescripcion) {
		prescripcionDAO.save(prescripcion);
	}

	public void eliminarPrescripcion(Prescripcion prescripcion) {
		prescripcionDAO.delete(prescripcion);
	}

	public List<Prescripcion> buscarTodos() {
		return prescripcionDAO.findAll();
	}

	public List<Prescripcion> buscarActivos() {
		return prescripcionDAO.findByActivoTrue();
	}

	public Prescripcion buscarPorId(Long id) {
		return prescripcionDAO.findById(id).orElse(null);
	}

	public List<Prescripcion> buscarPorPaciente(Long pacienteId) {
		if(pacienteId != null && pacienteId != 0){
			return prescripcionDAO.findByPacienteId(pacienteId);
		}else{
			return prescripcionDAO.findAll();
		}
	}

	public List<Prescripcion> buscarPorMedico(Long medicoId) {
		if(medicoId != null && medicoId != 0){
			return prescripcionDAO.findByMedicoId(medicoId);
		}else{
			return prescripcionDAO.findAll();
		}
	}
}