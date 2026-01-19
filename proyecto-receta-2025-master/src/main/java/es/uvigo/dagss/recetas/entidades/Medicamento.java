package es.uvigo.dagss.recetas.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;
import jakarta.validation.constraints.NotNull;

import 

@Entity
public class Medicamento{
	@Id
	@TableGenerator(name = "MEDICAMENTO_GEN", table = "GENERATOR_TABLE", pkColumnName = "GEN_KEY",
	ValueColumnName = "GEN_VALUE", pkColumnValue = "MEDICAMENTO_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "MEDICAMENTO_GEN")
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

	private boolean activo = true;

	public Medicamento(){ }

	public Medicamento(String nombreComercial, String principioActivo, String familia, int dosis, int existencias){
		this.nombreComercial = nombreComercial;
		this.principioActivo = principioActivo;
		this.familia = familia;
		this.dosis = dosis;
		this.existencias = existencias;
	}

	public Long getId(){
		return id;
	}

	public String getFabricante(){
		return fabricante;
	}

	public void setFabricante(String fabricante){
		this.fabricante = fabricante;
	}

	public String getNombreComercial(){
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial){
		this.nombreComercial = nombreComercial;
	}

	public String getPrincipioActivo(){
		return principioActivo;
	}

	public void setPrincipioActivo(String principioActivo){
		this.principioActivo = principioActivo;
	}

	public String getFamilia(){
		return familia;
	}

	public void setFamilia(String familia){
		this.familia = familia;
	}

	public int getDosis(){
		return dosis;
	}

	public void setDosis(int dosis){
		this.dosis = dosis;
	}

	public int getExistencias(){
		return existencias;
	}

	public void setExistencias(int existencias){
		this.existencias = existencias;
	}

	public boolean isActivo(){
		return activo;
	}

	public boolean setActivo(boolean activo){
		this.activo = activo;
	}

	@Override
    public String toString() {
        return "Medicamento[" + "id=" + id + ", nombreComercial=" + nombreComercial + ", principioActivo=" + principioActivo + ", familia=" + familia + ", dosis=" + dosis + ", existencias=" + existencias + ']';
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
        Medicamento other = (Medicamento) obj;
        if (this.id != null) {
            return this.id.equals(other.getId());
        }
        return super.equals(obj);
    }
}