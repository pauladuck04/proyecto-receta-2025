package es.uvigo.dagss.recetas.entidades;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotNull;
import es.uvigo.dagss.recetas.utils.ValidationUtils;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@DiscriminatorValue(value = "PACIENTE")
public class Paciente extends Usuario {

    @NotNull
    private String telefono;

    @NotNull
    private String dni;

    @NotNull
    private String nss;

    @NotNull
    @ManyToOne(targetEntity = Medico.class)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Medico medico;

    @NotNull
    private String email;

    @NotNull
    private String nombre;

    @NotNull
    @Embedded
    private Direccion direccion;

    @ManyToOne(targetEntity = CentroSalud.class)
    @NotNull
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private CentroSalud centroSalud;
   
    public Paciente() {
        super(TipoUsuario.PACIENTE);        
    }

    public Paciente(String login, String password, String telefono, Medico medico, Direccion direccion, CentroSalud centro_salud, String dni, String nss, String email, String nombre, boolean activo) {
        super(TipoUsuario.PACIENTE, login, password);
        this.telefono = telefono;
        this.dni = dni;
        this.nss = nss;
        this.email = email;
        this.direccion = direccion;
        this.nombre = nombre;
        this.medico = medico;
        this.centroSalud = centro_salud;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        if(medico.getCentroSalud().getId() == this.getCentroSalud().getId()){
            this.medico = medico;
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if(ValidationUtils.validarTelefono(telefono)){
            this.telefono = telefono;
        }
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if(ValidationUtils.validarDni(dni)){
            this.dni = dni;
        }
    }

    public String getNss() {
        return nss;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        if(ValidationUtils.validarEmail(email)){
            this.email = email;
        }
    }

    public String getNombre(){
        return nombre;
    }

    public CentroSalud getCentroSalud() {
        return centroSalud;
    }

    @Override
    public String toString(){
        return super.toString() + "paciente [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email
                + ", nss=" + nss + ", DNI=" + dni + ", medico="+ medico + ", centro de salud=" + centroSalud + "]";
    }
}
