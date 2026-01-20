package es.uvigo.dagss.recetas.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;


@Embeddable
public class Direccion{
	@JsonIgnore
    @NotNull
	private String calle;

	@NotNull
	private String localidad;

    @JsonIgnore
	@NotNull
	private String codigoPostal;

	@NotNull
	private String provincia;

	public Direccion(){ }

	public Direccion(String calle, String localidad, String codigoPostal, String provincia){
		this.calle = calle;
		this.localidad = localidad;
		this.codigoPostal = codigoPostal;
		this.provincia = provincia;
	}

	public String getCalle(){
		return calle;
	}

	public void setCalle(String calle){
		this.calle = calle;
	}

	public String getLocalidad(){
		return localidad;
	}

	public void setLocalidad(String ciudad){
		this.localidad = localidad;
	}

	public String getCodigoPostal(){
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal){
		this.codigoPostal = codigoPostal;
	}
	
	public String getProvincia(){
		return provincia;
	}

	public void setProvincia(String provincia){
		this.provincia = provincia;
	}

	@Override
	public String toString(){
		return "Direccion [" + "calle=" + calle + ", localidad=" + localidad + ", codigo postal=" + codigoPostal + "provincia=" + provincia + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Direccion that = (Direccion) o;

		return Objects.equals(calle, that.calle) &&
			   Objects.equals(localidad, that.localidad) &&
			   Objects.equals(codigoPostal, that.codigoPostal) &&
			   Objects.equals(provincia, that.provincia);
	}

	@Override
	public int hashCode() {
		return Objects.hash(calle, localidad, codigoPostal, provincia);
	}
}	