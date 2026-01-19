package es.uvigo.dagss.recetas.services;

import java.util.List;
import es.uvigo.dagss.recetas.entidades.Prescripcion;
import es.uvigo.dagss.recetas.entidades.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import es.uvigo.dagss.recetas.daos.PrescripcionDAO;
import es.uvigo.dagss.recetas.daos.RecetaDAO;
import es.uvigo.dagss.recetas.entidades.Receta;
import es.uvigo.dagss.recetas.strategies.EstrategiaGeneracionRecetas;
import java.time.LocalDate;


@Service
public class PrescripcionServiceImpl implements PrescripcionService {
	@Autowired
    private PrescripcionDAO prescripcionDAO;

	@Autowired
    private RecetaDAO recetaDAO;

	@Autowired
    private EstrategiaGeneracionRecetas planRecetasStrategy;

	public PrescripcionServiceImpl(){ }

    public void crearPrescripcion(Prescripcion prescripcion, Medico medico) {
        prescripcion.setMedico(medico);
        prescripcion.setFechaInicio(LocalDate.now());
        prescripcion.setActivo(true);
        Prescripcion guardada = prescripcionDAO.save(prescripcion);
        List<Receta> plan = planRecetasStrategy.generarRecetas(guardada);
        
		recetaDAO.saveAll(plan);
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