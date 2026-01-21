package es.uvigo.dagss.recetas.entidades;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Embedded;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import es.uvigo.dagss.recetas.utils.ValidationUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "MEDICO")
public class Medico extends Usuario {

    @NotNull
    private String numeroColegiado;

    @NotNull
    private String nombre;

    @NotNull
    private String apellidos;

    @NotNull
    private String telefono;

    @NotNull
    private String email;

    @NotNull
    private String dni;

    @ManyToOne(targetEntity = CentroSalud.class)
    @NotNull
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private CentroSalud centroSalud;

    @Embedded
    @NotNull
    private Direccion direccion;

    private Boolean activo = true;
    
    public Medico() {
        super(TipoUsuario.MEDICO);
    }

    public Medico(String login, String password, String numeroColegiado, String nombre, String apellidos, String telefono, String email, String dni, Direccion direccion) {
        super(TipoUsuario.MEDICO, login, password);
        this.numeroColegiado = numeroColegiado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.dni = dni;
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        if(ValidationUtils.validarTelefono(telefono)){
            this.telefono = telefono;
        }
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if(ValidationUtils.validarDni(dni)){
            this.dni = dni;
        }
    }

    public String getNumeroColegiado() {
        return numeroColegiado;
    }

    public String getApellidos(){
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(ValidationUtils.validarEmail(email)){
            this.email = email;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public CentroSalud getCentroSalud() {
        return centroSalud;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireecion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Boolean getActivo() {
        return activo;
    }

    @Override
    public String toString(){
        return super.toString() + "medico [nombre=" + nombre + ", apellidos=" + apellidos + ", numero de colegiado=" + numeroColegiado + ", telefono=" + telefono
                + ", email=" + email + ", DNI=" + dni + ", direccion=" + direccion + "]";
    }
}
