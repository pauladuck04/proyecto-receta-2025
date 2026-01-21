package es.uvigo.dagss.recetas.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Embeddable
public class Direccion{
    @NotNull
	private String calle;

	@NotNull
	private String localidad;

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

    @Override
	public String toString(){
		return "Direccion [" + "calle=" + calle + ", localidad=" + localidad + ", codigo postal=" + codigoPostal + "provincia=" + provincia + "]";
	}
}	