package es.uvigo.dagss.recetas.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uvigo.dagss.recetas.daos.CitaDAO;
import es.uvigo.dagss.recetas.daos.MedicoDAO;
import es.uvigo.dagss.recetas.daos.PacienteDAO;
import es.uvigo.dagss.recetas.entidades.Cita;
import es.uvigo.dagss.recetas.entidades.EstadoCita;
import es.uvigo.dagss.recetas.entidades.Medico;
import es.uvigo.dagss.recetas.entidades.Paciente;

@Service
public class CitaService{
	@Autowired
	private CitaDAO citaDAO;

	@Autowired
	private PacienteDAO pacienteDAO;

	@Autowired
	private MedicoDAO medicoDAO;

	public CitaService(){ }

	public List<Cita> buscarTodas(){
		return citaDAO.findAll();
	}

	public Cita buscarPorId(Long id){
		return citaDAO.findById(id).orElse(null);
	}

	public List<Cita> listarFiltrado(LocalDate fecha, Long medicoId, Long pacienteId){
		if(medicoId != null && medico != 0 && pacienteId != null && pacienteId != 0){
			return citaDAO.findByFechaAndMedicoIdAndPacienteId(fecha, medicoId, pacienteId);
		}

		if(medicoId != null && medicoId != 0){
			return citaDAO.findByFechaAndMedicoId(fecha, medicoId);
		}

		if(pacienteId != null && pacienteId != 0){
			return citaDAO.findByFechaAndMedicoId(fecha, pacienteId);
		}

		return citaDAO.findByFechaOrderByHoraInicioAsc(fecha);
	}

	public void anularCita(Long id) {
        Optional<Cita> cita = citaDAO.findById(id);
        if (cita.isPresent()) {
            Cita citaExistente = cita.get();
            citaExistente.setEstadoCita(EstadoCita.ANULADA);
            guardar(citaExistente);
        }
    }

}