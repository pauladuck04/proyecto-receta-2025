package es.uvigo.dagss.recetas.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Medicamento{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String nombreComercial;

	@NotNull
	private String principioActivo;

	@NotNull
	private String familia;

	@NotNull
	private int dosis;

	@NotNull
	private int existencias;

	@NotNull
	private String fabricante;

    @NotNull
    private boolean activo = true;

	public Medicamento(){ }

	public Medicamento(String nombreComercial, String principioActivo, String familia, String fabricante, int dosis, int existencias){
		this.nombreComercial = nombreComercial;
		this.principioActivo = principioActivo;
		this.familia = familia;
		this.dosis = dosis;
		this.existencias = existencias;
        this.fabricante = fabricante;
	}

	public Long getId(){
		return id;
	}

	public String getFabricante(){
		return fabricante;
	}

    public String getNombreComercial(){
		return nombreComercial;
	}

    public String getPrincipioActivo(){
		return principioActivo;
	}

    public String getFamilia(){
		return familia;
	}

    public int getDosis(){
		return dosis;
	}

    public int getExistencias(){
		return existencias;
	}

    public boolean isActivo(){
		return activo;
	}

    @Override
    public String toString() {
        return "Medicamento[" + "id=" + id + ", nombreComercial=" + nombreComercial + ", principioActivo=" + principioActivo + ", familia=" + familia + ", dosis=" + dosis + ", existencias=" + existencias + ']';
    }
}