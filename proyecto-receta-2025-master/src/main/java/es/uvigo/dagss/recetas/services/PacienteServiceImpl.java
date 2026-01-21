package es.uvigo.dagss.recetas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.uvigo.dagss.recetas.entidades.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uvigo.dagss.recetas.daos.CitaDAO;
import es.uvigo.dagss.recetas.daos.PacienteDAO;

@Service
public class PacienteServiceImpl implements PacienteService{
	@Autowired
	private PacienteDAO pacienteDAO;

	@Autowired
	private CitaDAO citaDAO;

	public PacienteServiceImpl(){ }

	public void crearPaciente(Paciente paciente){
		String dni = paciente.getDni();
		paciente.setPassword(dni);	
		pacienteDAO.save(paciente);
	}

	public void actualizarPaciente(Paciente paciente){
		pacienteDAO.save(paciente);
	}

	public void eliminarPaciente(Paciente paciente) {
        paciente.setActivo(false);
        pacienteDAO.save(paciente);
    }

	public Paciente buscarPorId(Long id) {
        return pacienteDAO.findById(id).orElse(null);
    }

	public List<Paciente> buscarActivos() {
        return pacienteDAO.findByActivoTrue();
    }

	public List<Paciente> buscarPorNombre(String nombre){
		if(nombre != null && !nombre.isEmpty()){
			return pacienteDAO.findByNombreContainingIgnoreCase(nombre);
		}else{
			return pacienteDAO.findAll();
		}
	}

	public List<Paciente> buscarPorMedico(Long medicoId, Long centroId){
        List<Paciente> pacientes = new ArrayList<>();
        if(centroId != null && centroId != 0 && medicoId != null && medicoId != 0){
            return pacienteDAO.findByCentroSaludIdAndMedicoId(centroId, medicoId);
        } else{
			return pacienteDAO.findAll();
		}
	}

	public List<Paciente> buscarPorLocalidad(String localidad){
		if(localidad != null && !localidad.isEmpty()){
			return pacienteDAO.findByDireccionLocalidadContainingIgnoreCase(localidad);
		}else{
			return pacienteDAO.findAll();
		}
	}

    public List<Cita> buscarCitasPlanificadas(Long pacienteId) {
        Optional<Paciente> paciente = pacienteDAO.findById(pacienteId);
        if (paciente.isPresent()) {
            return citaDAO.findByPacienteAndEstadoCita(paciente.get(), EstadoCita.PLANIFICADA);
        } else {
            throw new RuntimeException("Paciente no encontrado");
        }
    }
}