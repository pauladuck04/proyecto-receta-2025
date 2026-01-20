package es.uvigo.dagss.recetas.entidades;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

@Entity
public class Receta {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@ManyToOne(targetEntity = Prescripcion.class)
	@NotNull
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

	public void setPrescripcion(Prescripcion prescripcion){
		this.prescripcion = prescripcion;
	}

	public int getCantidad(){
		return cantidad;
	}

	public void setCantidad(int cantidad){
		this.cantidad = cantidad;
	}

	public estado getEstado(){
		return estado;
	}

	public void setEstado(estado estado){
		this.estado = estado;
	}

	public LocalDate getFechaInicio(){
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio){
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin(){
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin){
		this.fechaFin = fechaFin;
	}

	public Farmacia getFarmacia(){
		return farmacia;
	}

	public void setFarmacia(Farmacia farmacia){
		this.farmacia = farmacia;
	}

	@Override
    public String toString() {
        return "Receta[" + "id=" + id + ", prescripcion=" + prescripcion + ", fecha de inicio=" + fechaInicio.toString() + ", fecha de fin=" + fechaFin.toString() + ", cantidad=" + cantidad
        + ", estado=" + estado + ", farmacia=" + farmacia + ']';
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
        Receta other = (Receta) obj;
        if (this.id != null) {
            return this.id.equals(other.getId());
        }
        return super.equals(obj);
    }
}
