package es.uvigo.dagss.recetas.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.TableGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
public class Prescripcion{
	@TableGenerator(name = "PRESCRIPCION_GEN", table = "GENERATOR_TABLE", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VALUE", pkColumnValue = "PRESCRIPCION_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "PRESCRIPCION_GEN")
    @Id
    private Long id;

    @ManyToOne(targetEntity = Medicamento.class)
    @NotNull
    private Medicamento medicamento;

    @ManyToOne(targetEntity = Paciente.class)
    @NotNull
    private Paciente paciente;

    @ManyToOne(targetEntity = Medico.class)
    @NotNull
    private Medico medico;

    @NotNull
    private String indicaciones;

    @NotNull
    private int dosis;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private LocalDate fechaInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private LocalDate fechaFin;

    @NotNull
    private boolean activo = true;

    public Prescripcion(){ }

    public Prescripcion(Medicamento medicamento, Paciente paciente, 
    Medico medico, String indicaciones, int dosis, LocalDate fechaInicio, LocalDate fechaFin){
        this.medicamento = medicamento;
        this.paciente = paciente;
        this.medico = medico;
        this.indicaciones = indicaciones;
        this.dosis = dosis;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Long getId(){
        return id;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public int getDosis() {
        return dosis;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isActivo(){
        return activo;
    }

    public void setActivo(boolean activo){
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Prescripcion[" + "id=" + id + ", medicamento=" + medicamento + ", paciente=" + paciente + ", medico=" + medico + ", indicaciones=" + indicaciones 
        + ", dosis=" + dosis + ", fecha de inicio=" + fechaInicio.toString() + ",fechaFin=" + fechaFin.toString() + ']';
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
        Prescripcion other = (Prescripcion) obj;
        if (this.id != null) {
            return this.id.equals(other.getId());
        }
        return super.equals(obj);
    }
}