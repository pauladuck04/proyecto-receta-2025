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

	private final LocalTime HORA_INICIO_CONSULTA = LocalTime.of(8, 30);
	private final LocalTime HORA_FIN_CONSULTA = LocalTime.of(15, 30);
	private final int DURACION_CITA_MINUTOS = 15;


	public CitaService(){ }

	public List<Cita> buscarTodas(){
		return citaDAO.findAll();
	}

	public Cita buscarPorId(Long id){
		return citaDAO.findById(id).orElse(null);
	}

	public List<Cita> buscarPorMedico(Long medicoId){
		return citaDAO.findByMedicoId(medico);
	}

	public List<Cita> buscarPorPaciente(Long pacienteId){
		return citaDAO.findByPacienteId(paciente);
	}

	public void anularCita(Long id) {
        Optional<Cita> cita = citaDAO.findById(id);
        if (cita.isPresent()) {
            Cita citaExistente = cita.get();
            citaExistente.setEstadoCita(EstadoCita.ANULADA);
            guardar(citaExistente);
        }
    }

	public Cita actualizarCita(Cita cita) {
		return citaDAO.save(cita);
	}

	public void eliminarCita(Cita cita) {
		citaDAO.delete(cita);
	}

	public List<Cita> buscarPorFecha(String fecha) {
		citaDAO.findByFecha(fecha);
	}

	public List<Cita> buscarActivos() {
		return citaDAO.findByActivoTrue();
	}

	public List<Cita> buscarPorEstado(Estado estado){
		return citaDAO.findByEstado(estado);
	}

	public List<LocalTime> obtenerHuecos(Medico medico, LocalDate fecha){
		List<Cita citasExistentes = citaDAO.findByMedicoAndFecha(medico, fecha);
		citasExistentes = citasExistentes.findByEstado(EstadoCita.PLANIFICADA);

		List<LocalTime> horasOcupadas = citasExistentes.stream()
			.map(cita -> cita.getHora())
			.collect(Collectors.toList());

		List<LocalTime> huecosLibres = new ArrayList<>();
		LocalTime horaActual = HORA_INICIO_CONSULTA;

		while(horaActual.isBefore(HORA_FIN_CONSULTA)) {
			if(!horasOcupadas.contains(horaActual)) {
				huecosLibres.add(horaActual);
			}
			horaActual = horaActual.plusMinutes(DURACION_CITA_MINUTOS);
		}
		return huecosLibres;
	}

	public Cita crearCita(Paciente paciente, LocalDate fecha, LocalTime horaSeleccionada){
	{
		Cita nuevaCita = new Cita();

		nuevaCita.setPaciente(paciente);
		nuevaCita.setFecha(fecha);
		nuevaCita.setHoraInicio(horaSeleccionada);
		nuevaCita.setMedico(paciente.getMedico());

		nuevaCita.setEstadoCita(EstadoCita.PLANIFICADA);
		nuevaCita.setActivo(true);
		nuevaCita.setDuracion(15);

		return citaDAO.save(nuevaCita);
	}
}