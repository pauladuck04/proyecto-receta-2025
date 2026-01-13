package es.uvigo.dagss.recetas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uvigo.dagss.recetas.daos.CitaDAO;
import es.uvigo.dagss.recetas.daos.PacienteDAO;
import es.uvigo.dagss.recetas.entidades.CentroSalud;
import es.uvigo.dagss.recetas.entidades.Cita;
import es.uvigo.dagss.recetas.entidades.Medico;
import es.uvigo.dagss.recetas.entidades.Paciente;

@Service
public class PacienteService{
	@Autowired
	private PacienteDAO pacienteDAO;

	@Autowired
	private CitaDAO citaDAO;

	public PacienteService(){ }

	public void crearPaciente(Paciente paciente){
		String dni = medico.getDni();
		paciente.setPassword(dni);	
		pacienteDAO.save(paciente);
	}

	public Paciente actualizarPaciente(Paciente paciente){
		return pacienteDAO.save(paciente);
	}

	public void eliminarPaciente(Paciente paciente) {
        paciente.setActivo(false);
        pacienteDAO.save(paciente);
    }

	public Paciente buscarPorId(Long id) {
        return pacienteDAO.findById(id).orElse(null);
    }

	public List<Paciente> buscarTodos(){
		return pacienteDAO.findAll();
	}

	public List<Paciente> buscarActivos() {
        return pacienteDAO.findByActivoTrue();
    }

	public List<Paciente> listarFiltrado(String texto, Long centroId, Long medicoId){
		if(medicoId != null && medicoId != 0){
			return pacienteDAO.findByMedicoId(medicoId);
		}
	
		if(centroId != null && centroId != 0){
			return pacienteDAO.findByCentroSaludId(centroId);
		}

		if(texto != null && !texto.isEmpty()){
			return pacienteDAO.findByNombreContainingIgnoreCaseOrDireccionLocalidadContainingIgnoreCase(texto, texto);
		}
		
		return pacienteDAO.findAll();
	}
}