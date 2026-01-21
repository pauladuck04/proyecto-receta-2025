package es.uvigo.dagss.recetas.services;

import java.util.List;
import es.uvigo.dagss.recetas.entidades.Cita;
import es.uvigo.dagss.recetas.entidades.Medico;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import es.uvigo.dagss.recetas.entidades.Paciente;
import es.uvigo.dagss.recetas.entidades.EstadoCita;

public interface CitaService{
	public void actualizarCita(Cita cita);
	public void eliminarCita(Cita cita);
	public List<Cita> buscarActivos();
	public Cita buscarPorId(Long id);
	public void anularCita(Long id);
	public List<Cita> buscarPorFecha(LocalDateTime fechaHora);
	public List<Cita> buscarPorMedico(Long medicoId);
	public List<Cita> buscarPorPaciente(Long pacienteId);
	public List<LocalTime> obtenerHuecosDisponibles(Medico medico, LocalDateTime fechaHora);
    public Cita crear(Cita cita);
    private Cita guardar(Cita cita){
        return null;
    }
    public Cita crearCita(Long pacienteId, Long medicoId, LocalDateTime fechaHora);
    public void completarCita(Long id);
    public void marcarCitaAusente(Long id);
}