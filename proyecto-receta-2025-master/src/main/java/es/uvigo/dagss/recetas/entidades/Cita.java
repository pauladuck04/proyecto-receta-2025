package es.uvigo.dagss.recetas.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cita implements Serializable {

    public static final int MINUTOS_APERTURA = 8*60+30;
    public static final int MINUTOS_CIERRE = 15*60+30;
    public static final int MINUTOS_HUECO = 15;
    public static final int NUMERO_HUECOS = (MINUTOS_CIERRE - MINUTOS_APERTURA) / MINUTOS_HUECO;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "paciente_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
	private Paciente paciente;

	@ManyToOne
	@NotNull
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
	@JoinColumn(name = "medico_id")
	private Medico medico;

	@NotNull
	private LocalDateTime fechaHora;

	@Enumerated(EnumType.STRING)
	@NotNull
	private EstadoCita estadoCita;

	@NotNull
	private int duracion;

    @NotNull
	private Boolean activo = true;

	public Cita() { }

	public Cita(Paciente paciente, Medico medico, LocalDateTime fechaHora, EstadoCita estadoCita, int duracion) {
		this.paciente = paciente;
		this.medico = medico;
		this.fechaHora = fechaHora;
		this.estadoCita = estadoCita;
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

    @Override
    public String toString() {
        return "Cita[" + "id=" + id + ", paciente=" + paciente + ", medico=" + medico + ", fecha="
                + fechaHora.toLocalDate().toString() + ", hora" + fechaHora.toLocalTime().toString()
                + ", estadoCita=" + estadoCita + ", duracion=" + duracion + ']';
    }

}