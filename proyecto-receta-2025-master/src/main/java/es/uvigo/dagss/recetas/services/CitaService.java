package es.uvigo.dagss.recetas.services;

import java.util.List;
import es.uvigo.dagss.recetas.entidades.Cita;
import es.uvigo.dagss.recetas.entidades.Medico;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface CitaService{
	void actualizarCita(Cita cita);
	void eliminarCita(Cita cita);
	List<Cita> buscarActivos();
	Cita buscarPorId(Long id);
	void anularCita(Long id);
	List<Cita> buscarPorFecha(LocalDateTime fechaHora);
	List<Cita> buscarPorMedico(Long medicoId);
	List<Cita> buscarPorPaciente(Long pacienteId);
	List<LocalTime> obtenerHuecosDisponibles(Medico medico, LocalDateTime fechaHora);
    Cita crear(Cita cita);
    private Cita guardar(Cita cita){
        return null;
    }
    Cita crearCita(Long pacienteId, Long medicoId, LocalDateTime fechaHora);
    void completarCita(Long id);
    void marcarCitaAusente(Long id);
}