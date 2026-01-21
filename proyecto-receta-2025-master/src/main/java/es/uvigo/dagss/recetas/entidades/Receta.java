package es.uvigo.dagss.recetas.entidades;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Receta {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

    @ManyToOne(targetEntity = Prescripcion.class)
	@NotNull
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
	private Prescripcion prescripcion;

    @NotNull
	private LocalDate fechaInicio;

    @NotNull
	private LocalDate fechaFin;

    @NotNull
	private int cantidad;

	public enum estado{
		PLANIFICADA,
		SERVIDA,
		ANULADA
	}

    @Enumerated(EnumType.STRING)
	private estado estado;

    @ManyToOne(targetEntity = Farmacia.class)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
	private Farmacia farmacia;

	public Receta(){  }

	public Receta(Prescripcion prescripcion, LocalDate fechaInicio, LocalDate fechaFin, int cantidad, estado estado){
		this.prescripcion = prescripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cantidad = cantidad;
		this.estado = estado;
		this.farmacia = null;
	}
	
	public Receta(Prescripcion prescripcion, LocalDate fechaInicio, LocalDate fechaFin, int cantidad, estado estado, Farmacia farmacia){
		this.prescripcion = prescripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cantidad = cantidad;
		this.estado = estado;
		this.farmacia = farmacia;
	}
	
	public Long getId(){
		return id;
	}

	public Prescripcion getPrescripcion(){
		return prescripcion;
	}

    public int getCantidad(){
		return cantidad;
	}

    public estado getEstado(){
		return estado;
	}

    public LocalDate getFechaInicio(){
		return fechaInicio;
	}

    public LocalDate getFechaFin(){
		return fechaFin;
	}

    public Farmacia getFarmacia(){
		return farmacia;
	}

    @Override
    public String toString() {
        return "Receta[" + "id=" + id + ", prescripcion=" + prescripcion + ", fecha de inicio=" + fechaInicio.toString() + ", fecha de fin=" + fechaFin.toString() + ", cantidad=" + cantidad
        + ", estado=" + estado + ", farmacia=" + farmacia + ']';
    }
}
