package es.uvigo.dagss.recetas.entidades;

import jakarta.persistence.Embeddable;
import jakarta.validation.constrains.NotNull;

@Embeddable
public class Direccion{
	@NotNull
	private String calle;

	@NotNull
	private String ciudad;

	@NotNull
	private String codigoPostal;

	@NotNull
	private String provincia;

	public Direccion(){ }

	public Direccion(String calle, String ciudad, String codigoPostal, String provincia){
		this.calle = calle;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
		this.provincia = provincia;
	}

	public String getCalle(){
		return calle;
	}

	public void setCalle(String calle){
		this.calle = calle;
	}

	public String getCiudad(){
		return ciudad;
	}

	public void setCiudad(String ciudad){
		this.ciudad = ciudad;
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
		return "Direccion [" + "calle=" + calle ", ciudad=" + ciudad + ", codigo postal=" + codigoPostal + "provincia=" + provincia + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Direccion that = (Direccion) o;

		return Objects.equals(calle, that.calle) &&
			   Objects.equals(ciudad, that.ciudad) &&
			   Objects.equals(codigoPostal, that.codigoPostal) &&
			   Objects.equals(provincia, that.provincia);
	}

	@Override
	public int hashCode() {
		return Objects.hash(calle, ciudad, codigoPostal, provincia);
	}
}	