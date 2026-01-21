package es.uvigo.dagss.recetas.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import es.uvigo.dagss.recetas.utils.ValidationUtils;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class CentroSalud{
    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

    @NotNull
	private String nombre;

    @Embedded
	@NotNull
	private Direccion direccion;

	@NotNull
	private String telefono;

    @NotNull
	private boolean activo = true;

	@NotNull
	private String email;

	public CentroSalud() {
		super();
	}

	public CentroSalud(String nombre, Direccion direccion, String telefono, String email) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}


	public void setTelefono(String telefono) {
		if(ValidationUtils.validarTelefono(telefono)){
			this.telefono = telefono;
		}
	}

    public void setEmail(String email) {
		if(ValidationUtils.validarEmail(email)){
			this.email = email;
		}
	}

	@Override
    public String toString() {
        return "CentroSalud [" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", activo=" + activo + ", email=" + email + ']';
    }
}