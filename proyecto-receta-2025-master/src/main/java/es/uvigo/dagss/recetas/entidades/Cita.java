package es.uvigo.dagss.recetas.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

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
public class Cita implements Serializable {*
	public static final int MINUTOS_APERTURA = 8 * 60 + 30; // 8:30 AM
	public static final int MINUTOS_CIERRE = 15 * 60 + 30; //3:30 PM
	public static final int MINUTOS_CITA = 15;
	public static final int NUMERO_CITAS = (MINUTOS_CIERRE - MINUTOS_APERTURA) / MINUTOS_CITA;

	@Id
	@TableGenerator(name = "CITA_GEN", table = "CITA_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "CITA_GEN")
	private Long id;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "medico_id")
	private Medico medico;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date fechaHora;

	@NotNull
	private LocalDate fecha;

	@Enumerated(EnumType.STRING)
	@NotNull
	private EstadoCita estadoCita;

	@NotNull
	private int duracion;

	public Cita() { }

	public Cita(Paciente paciente, Medico medico, Date fechaHora, LocalDate fecha, EstadoCita estadoCita, int duracion) {
		this.paciente = paciente;
		this.medico = medico;
		this.fechaHora = fechaHora;
		this.fecha = fecha;
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

	public Date getFechaHora(){
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora){
		this.fechaHora = fechaHora;
	}

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
		return fecha;
	}

	public void setFecha(LocalDate fecha){
		this.fecha = fecha;
	}

	@Override
    public String toString() {
        return "Cita[" + "id=" + id + ", paciente=" + paciente + ", medico=" + medico + ", fechaHora=" + fechaHora + ", estadoCita=" + estadoCita + ", duracion=" + duracion + ']';
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