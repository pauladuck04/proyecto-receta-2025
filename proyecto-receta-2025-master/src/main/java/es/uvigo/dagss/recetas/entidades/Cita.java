package es.uvigo.dagss.recetas.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.time.LocalTime;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.TableGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
public class Cita implements Serializable {
	@Id
    @JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "medico_id")
	private Medico medico;

	@NotNull
	private LocalDateTime fechaHora;

	@Enumerated(EnumType.STRING)
	@NotNull
	private EstadoCita estadoCita;

    @JsonIgnore
	@NotNull
	private int duracion;

	private Boolean activo = true;

	public Cita() { }

	public Cita(Paciente paciente, Medico medico, LocalDateTime fechaHora, EstadoCita estadoCita, int duracion) {
		this.paciente = paciente;
		this.medico = medico;
		this.fechaHora = fechaHora;
		this.estadoCita = estadoCita;
		this.duracion = duracion;
	}

	public Long getId(){
		return id;
	}

	public Paciente getPaciente(){
		return paciente;
	}

	public void setPaciente(Paciente paciente){
		this.paciente = paciente;
	}

	public Medico getMedico(){
		return medico;
	}

	public void setMedico(Medico medico){
		this.medico = medico;
	}

    /*
	public LocalDateTime getFechaHora(){
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora){
		this.fechaHora = fechaHora;
	}
     */

	public EstadoCita getEstadoCita(){
		return estadoCita;
	}

	public void setEstadoCita(EstadoCita estadoCita){
		this.estadoCita = estadoCita;
	}

	public int getDuracion(){
		return duracion;
	}

	public void setDuracion(int duracion){
		this.duracion = duracion;
	}

	public LocalDate getFecha(){
		return fechaHora.toLocalDate();
	}

	public void setFecha(LocalDate fecha){
		this.fechaHora = LocalDateTime.of(fecha, this.fechaHora.toLocalTime());
	}

	public LocalTime getHora() {
		return fechaHora.toLocalTime();
	}

	public void setHora(LocalTime hora){
		this.fechaHora = LocalDateTime.of(this.fechaHora.toLocalDate(), hora);
	}

	public Boolean isActivo(){
		return activo;
	}

	public void setActivo(Boolean activo){
		this.activo = activo;
	}

	@Override
    public String toString() {
        return "Cita[" + "id=" + id + ", paciente=" + paciente + ", medico=" + medico + ", fecha="
                + fechaHora.toLocalDate().toString() + ", hora" + fechaHora.toLocalTime().toString()
                + ", estadoCita=" + estadoCita + ", duracion=" + duracion + ']';
    }

	@Override
    public int hashCode() {
        if (this.id != null) {
            return this.id.hashCode();
        }
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Cita other = (Cita) obj;
        if (this.id != null) {
            return this.id.equals(other.getId());
        }
        return super.equals(obj);
    }

}