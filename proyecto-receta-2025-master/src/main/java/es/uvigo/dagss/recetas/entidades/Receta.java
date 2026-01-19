package es.uvigo.dagss.recetas.entidades;

import java.util.Date;

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
	@TableGenerator(name = "RECETA_GEN", table = "GENERATOR_TABLE", pkColumnName = "GEN_KEY",
	valueColumnName = "GEN_VALUE", pkColumnValue = "RECETA_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "RECETA_GEN")
	@Id
	private Long id;

	@ManyToOne(targetEntity = Prescripcion.class)
	@NotNull
	private Prescripcion prescripcion;

	@NotNull
	private Date fechaInicio;

	@NotNull
	private Date fechaFin;

	@NotNull
	private int cantidad;

	public enum EstadoReceta{
		PLANIFICADA,
		SERVIDA,
		ANULADA
	}

	@Enumerated(EnumType.STRING)
	private EstadoReceta estado;

	@ManyToOne(targetEntity = Farmacia.class)
	private Farmacia farmacia;

	public Receta(){  }

	public Receta(Prescripcion prescripcion, Date fechaInicio, Date fechaFin, int cantidad, EstadoReceta estado){
		this.prescripcion = prescripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cantidad = cantidad;
		this.estado = estado;
		this.farmacia = null;
	}
	
	public Receta(Prescripcion prescripcion, Date fechaInicio, Date fechaFin, int cantidad, EstadoReceta estado, Farmacia farmacia){
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

	public Estado getEstado(){
		return estado;
	}

	public void setEstado(EstadoReceta estado){
		this.estado = estado;
	}

	public Date getFechaInicio(){
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio){
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin(){
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin){
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
