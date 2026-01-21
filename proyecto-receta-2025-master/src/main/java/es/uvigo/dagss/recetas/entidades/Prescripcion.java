package es.uvigo.dagss.recetas.entidades;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Entity
@Setter
public class Prescripcion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(targetEntity = Medicamento.class)
    @NotNull
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Medicamento medicamento;

    @ManyToOne(targetEntity = Paciente.class)
    @NotNull
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Paciente paciente;

    @ManyToOne(targetEntity = Medico.class)
    @NotNull
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Medico medico;

    @NotNull
    private String indicaciones;

    @NotNull
    private int dosis;

    @NotNull
    private LocalDate fechaInicio;

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

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public int getDosis() {
        return dosis;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public boolean isActivo(){
        return activo;
    }

    @Override
    public String toString() {
        return "Prescripcion[" + "id=" + id + ", medicamento=" + medicamento + ", paciente=" + paciente + ", medico=" + medico + ", indicaciones=" + indicaciones 
        + ", dosis=" + dosis + ", fecha de inicio=" + fechaInicio.toString() + ",fechaFin=" + fechaFin.toString() + ']';
    }
}