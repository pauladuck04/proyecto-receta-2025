package es.uvigo.dagss.recetas.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import es.uvigo.dagss.recetas.utils.ValidationUtils;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotNull;

import es.uvigo.dagss.recetas.entidades.Usuario;

@Entity
@DiscriminatorValue(value = "FARMACIA")
public class Farmacia extends Usuario {

    @NotNull
    private String nombre;

    @Embedded
    @NotNull
    private Direccion direccion;

    @JsonIgnore
    @NotNull
    private String telefono;

    @JsonIgnore
    @NotNull
    private String email;

    @JsonIgnore
    @NotNull
    private String dni;

    @JsonIgnore
    @NotNull
    private String nombreFarmaceutico;

    @JsonIgnore
    @NotNull
    private String apellidosFarmaceutico;

    @JsonIgnore
    @NotNull
    private String numero_colegiado;

    public Farmacia() {
        super(TipoUsuario.FARMACIA);
    }

    public Farmacia(String login, String password, String nombre, Direccion direccion, String telefono, String email,
    String nombreFarmaceutico, String apellidosFarmaceutico, String dni, String numeroColegiado) {
        super(TipoUsuario.FARMACIA, login, password);
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.nombreFarmaceutico = nombreFarmaceutico;
        this.apellidosFarmaceutico = apellidosFarmaceutico;
        this.dni = dni;
        this.numero_colegiado = numeroColegiado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono){
        if(ValidationUtils.validarTelefono(telefono)){
            this.telefono = telefono;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(ValidationUtils.validarEmail(email)){
            this.email = email;
        }
    }

    public String getNombreFarmaceutico() {
        return nombreFarmaceutico;
    }

    public void setNombreFarmaceutico(String nombreFarmaceutico) {
        this.nombreFarmaceutico = nombreFarmaceutico;
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
        return numero_colegiado;
    }

    public void setNumeroColegiado(String numeroColegiado) {
        this.numero_colegiado = numeroColegiado;
    }

    public String getApellidosFarmaceutico() {
        return apellidosFarmaceutico;
    }

    public void setApellidosFarmaceutico(String apellidosFarmaceutico) {
        this.apellidosFarmaceutico = apellidosFarmaceutico;
    }

	public Boolean isActivo() {
		return super.isActivo();
	}

    @Override
    public String toString() {
        return super.toString() + "farmacia [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email
                + ", nombreFarmaceutico=" + nombreFarmaceutico + ", apellidosFarmaceutico=" + apellidosFarmaceutico + ", DNI=" + dni
                + ", numeroColegiado=" + numero_colegiado + "]";
    }
}
