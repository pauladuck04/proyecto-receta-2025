package es.uvigo.dagss.recetas.services;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

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
public class CitaServiceImpl implements CitaService{
	@Autowired
	private CitaDAO citaDAO;

	@Autowired
	private PacienteDAO pacienteDAO;

	@Autowired
	private MedicoDAO medicoDAO;

	private final LocalTime HORA_INICIO_CONSULTA = LocalTime.of(8, 30);
	private final LocalTime HORA_FIN_CONSULTA = LocalTime.of(15, 30);
	private final int DURACION_CITA_MINUTOS = 15;

	public CitaServiceImpl(){ }

	public Cita buscarPorId(Long id){
		return citaDAO.findById(id).orElse(null);
	}

	public List<Cita> buscarPorMedico(Long medicoId){
		return citaDAO.findByMedicoId(medicoId);
	}

	public List<Cita> buscarPorPaciente(Long pacienteId){
		return citaDAO.findByPacienteId(pacienteId);
	}

	public void anularCita(Long id) {
        Optional<Cita> cita = citaDAO.findById(id);
        if (cita.isPresent()) {
            Cita citaExistente = cita.get();
            citaExistente.setEstadoCita(EstadoCita.ANULADA);
            guardar(citaExistente);
        } else {
            throw new RuntimeException("Cita no encontrada");
        }
    }

	public void actualizarCita(Cita cita) {
		citaDAO.save(cita);
	}

	public void eliminarCita(Cita cita) {
		citaDAO.delete(cita);
	}

	public List<Cita> buscarPorFecha(LocalDateTime fecha) {
		return citaDAO.findByFechaHoraOrderByFechaHoraAsc(fecha);
	}

	public List<Cita> buscarActivos() {
		return citaDAO.findByActivoTrue();
	}

	public List<LocalTime> obtenerHuecosDisponibles(Medico medico, LocalDateTime fecha){
		List<Cita> citasExistentes = citaDAO.findByMedicoAndFechaHoraOrderByFechaHoraAsc(medico, fecha);
		
		List<Cita> filtradas = citasExistentes.stream()
			.filter(c -> c.getEstadoCita().equals(EstadoCita.PLANIFICADA))
			.toList();

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

	public Cita crearCita(Long pacienteId, Long medicoId, LocalDateTime fechaHora){
        Optional<Paciente> paciente = pacienteDAO.findById(pacienteId);
        Optional<Medico> medico = medicoDAO.findById(medicoId);
        if (paciente.isPresent() && medico.isPresent()) {
            Cita nuevaCita = new Cita(paciente.get(), medico.get(), fechaHora, EstadoCita.PLANIFICADA, 15);
            return guardar(nuevaCita);
        } else {
            throw new RuntimeException("Paciente o Médico no encontrado");
        }

    }

    public Cita crear(Cita cita) {
        return guardar(cita);
    }

    private Cita guardar(Cita cita){
        Calendar cal = Calendar.getInstance();
        cal.setTime(Date.from(cita.getFechaHora().atZone(ZoneId.systemDefault()).toInstant()));
        if(estaHuecoDisponible(cita.getMedico(), cal.getTime(), horaAHueco(cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE)))){
            return citaDAO.save(cita);
        }else{
            throw new RuntimeException("Error: El médico no tiene un hueco libre en ese momento");
        }
    }

    public boolean estaHuecoDisponible(Medico medico, Date dia, int numeroHueco){
        return HuecosVaciosMedicoEnDia(medico, dia).get(numeroHueco) == "HUECO OCUPADO";
    }

    // la lista es del mismo tamaño que huecos hay, SIEMPRE, por lo que lista.get(i) siempre te dará info sobre el hueco numero i
    public List<String> HuecosVaciosMedicoEnDia(Medico medico, Date dia){
        Calendar cal = Calendar.getInstance();
        cal.setTime(dia);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        Date inicioAntiguo = cal.getTime();
        LocalDateTime inicio = inicioAntiguo.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date finAntiguo = cal.getTime();
        LocalDateTime fin = finAntiguo.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        List<Cita> citas = citaDAO.findByMedicoAndFechaHoraBetweenAndEstadoCita(medico, inicio, fin,EstadoCita.PLANIFICADA);
        List<String> huecos = getHuecosPosibles();

        int huecoCita = 0;
        for(var cita : citas){
            cal.setTime(Date.from(cita.getFechaHora().atZone(ZoneId.systemDefault()).toInstant()));
            huecoCita = horaAHueco(cal.get(Calendar.HOUR),cal.get(Calendar.MINUTE));
            huecos.set(huecoCita, "HUECO OCUPADO");
        }

        return huecos;
    }

    List<String> getHuecosPosibles(){
        ArrayList<String> huecos = new ArrayList<>();
        huecos.ensureCapacity(Cita.NUMERO_HUECOS);

        for (int i = 0 ; i < Cita.NUMERO_HUECOS; i++) {
            huecos.add(horaHueco(i) + ":"+ minutoHueco(i) + " - " + horaHueco(i+1) + ":" + minutoHueco(i+1));
        }
        return huecos;
    }

    public static int horaAHueco(int hora, int minutos){
        return (hora * 60 + minutos - Cita.MINUTOS_APERTURA) / Cita.MINUTOS_HUECO;
    }
    public static int horaHueco(int numHueco){
        return (Cita.MINUTOS_APERTURA + numHueco * Cita.MINUTOS_HUECO) / 60;
    }

    public static int minutoHueco(int numHueco){
        return (Cita.MINUTOS_APERTURA + numHueco * 15) % 60;
    }

    public void completarCita(Long citaId) {
        Cita cita = citaDAO.findById(citaId).orElse(null);
        if (cita != null) {
            cita.setEstadoCita(EstadoCita.COMPLETADA);
            citaDAO.save(cita);
        }
    }

    public void marcarCitaAusente(Long citaId) {
        Cita cita = citaDAO.findById(citaId).orElse(null);
        if (cita != null) {
            cita.setEstadoCita(EstadoCita.AUSENTE);
            citaDAO.save(cita);
        }
    }
}