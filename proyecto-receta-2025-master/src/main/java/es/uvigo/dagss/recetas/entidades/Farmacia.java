package es.uvigo.dagss.recetas.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import es.uvigo.dagss.recetas.utils.ValidationUtils;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@DiscriminatorValue(value = "FARMACIA")
public class Farmacia extends Usuario {

    @NotNull
    private String nombre;

    @Embedded
    @NotNull
    private Direccion direccion;

    @NotNull
    private String telefono;

    @NotNull
    private String email;

    @NotNull
    private String dni;

    @NotNull
    private String nombreFarmaceutico;

    @NotNull
    private String apellidosFarmaceutico;

    @NotNull
    private String numeroColegiado;

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
        this.numeroColegiado = numeroColegiado;
    }

    public void setTelefono(String telefono){
        if(ValidationUtils.validarTelefono(telefono)){
            this.telefono = telefono;
        }
    }

    public void setEmail(String email) {
        if(ValidationUtils.validarEmail(email)){
            this.email = email;
        }
    }

    public void setDni(String dni) {
        if(ValidationUtils.validarDni(dni)){
            this.dni = dni;
        }
    }

    public Boolean isActivo() {
		return super.isActivo();
	}

    @Override
    public String toString() {
        return super.toString() + "farmacia [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email
                + ", nombreFarmaceutico=" + nombreFarmaceutico + ", apellidosFarmaceutico=" + apellidosFarmaceutico + ", DNI=" + dni
                + ", numeroColegiado=" + numeroColegiado + "]";
    }
}
