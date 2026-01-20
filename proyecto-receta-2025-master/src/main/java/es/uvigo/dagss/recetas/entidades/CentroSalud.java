package es.uvigo.dagss.recetas.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import es.uvigo.dagss.recetas.utils.ValidationUtils;


@Entity
public class CentroSalud{
	@Id
    @JsonIgnore
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nombre;
	
	@Embedded
	@NotNull
	private Direccion direccion;

	@JsonIgnore
	@NotNull
	private String telefono;

	@NotNull
	private boolean activo = true;

    @JsonIgnore
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setTelefono(String telefono) {
		if(ValidationUtils.validarTelefono(telefono)){
			this.telefono = telefono;
		}
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public boolean isActivo() {
		return activo;
	}

	public String getEmail() {
		return email;
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
        CentroSalud other = (CentroSalud) obj;
        if (this.id != null) {
            return this.id.equals(other.getId());
        }
        return super.equals(obj);
    }
}